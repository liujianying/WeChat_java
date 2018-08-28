package com.tencent.mm.aa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.support.CancellationSignal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

public final class f {
    private static int dHi = 150;
    private static int dHj = 150;
    static final Map<String, Integer> dHm;
    private static a dHq = new a(dHj);
    private d dHk;
    com.tencent.mm.bs.b.b<Boolean> dHl;
    private k<c, String> dHn = new k<c, String>() {
    };
    private Vector<WeakReference<c>> dHo = new Vector();
    private final c dHp = new c() {
        public final void jX(String str) {
            Collection vector = new Vector();
            x.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", str, Integer.valueOf(f.this.dHo.size()), Integer.valueOf(f.this.dHo.size()));
            Vector vector2 = new Vector();
            synchronized (f.this.dHo) {
                for (int i = 0; i < f.this.dHo.size(); i++) {
                    WeakReference weakReference = (WeakReference) f.this.dHo.get(i);
                    if (weakReference != null) {
                        c cVar = (c) weakReference.get();
                        if (cVar != null) {
                            vector2.add(cVar);
                        } else {
                            vector.add(weakReference);
                        }
                    }
                }
                f.this.dHo.removeAll(vector);
            }
            for (int i2 = 0; i2 < vector2.size(); i2++) {
                ((c) vector2.get(i2)).q(str);
            }
        }
    };

    private static class a implements Runnable {
        private long bwo;
        private boolean dHs = false;
        private String dHt;
        private String dHu;

        a(String str, String str2) {
            this.dHt = str;
            this.dHu = str2;
            this.bwo = 100;
        }

        public final void run() {
            if (this.bwo > 0) {
                LockSupport.parkNanos(this.bwo * 1000000);
                Thread.interrupted();
            }
            String str = "MicroMsg.AvatarStorage";
            String str2 = "Migrate avatar, [%s] %s => %s";
            Object[] objArr = new Object[3];
            objArr[0] = this.dHs ? "DIR" : "FILE";
            objArr[1] = this.dHt;
            objArr[2] = this.dHu;
            x.i(str, str2, objArr);
            if (this.dHs) {
                j.q(this.dHt, this.dHu, true);
                return;
            }
            FileOp.mL(new File(this.dHu).getParent());
            if (FileOp.y(this.dHt, this.dHu) >= 0) {
                FileOp.deleteFile(this.dHt);
            }
        }
    }

    public interface c {
        /* renamed from: jX */
        void q(String str);
    }

    public static class d {
        public static boolean jY(String str) {
            Bitmap jZ = jZ(str);
            if (jZ == null || jZ.isRecycled()) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = FileOp.jx(str);
                jZ.compress(CompressFormat.PNG, 100, outputStream);
                FileOp.deleteFile(str + ".bm");
                if (outputStream == null) {
                    return true;
                }
                try {
                    outputStream.close();
                    return true;
                } catch (IOException e) {
                    return true;
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.AvatarStorage", e2, "Cannot write avatar file: %s", str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }

        public static Bitmap jZ(String str) {
            Exception e;
            OutOfMemoryError e2;
            String str2 = str + ".bm";
            InputStream openRead;
            ReadableByteChannel newChannel;
            try {
                if (FileOp.cn(str2)) {
                    int mI = (int) FileOp.mI(str2);
                    if (mI <= 0 || !(mI == 36864 || mI == 36880)) {
                        eL(str);
                        x.e("MicroMsg.AvatarStorage", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(mI), str2);
                        return null;
                    }
                    openRead = FileOp.openRead(str2);
                    try {
                        newChannel = Channels.newChannel(openRead);
                        try {
                            boolean z;
                            Buffer allocateDirect = ByteBuffer.allocateDirect(36864);
                            newChannel.read(allocateDirect);
                            allocateDirect.position(0);
                            if (mI == 36880) {
                                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(16);
                                newChannel.read(allocateDirect2);
                                if (allocateDirect2.getLong(0) != 1) {
                                    x.e("MicroMsg.AvatarStorage", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(mI), str2);
                                    newChannel.close();
                                    openRead.close();
                                    eL(str);
                                    return null;
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                            x.d("MicroMsg.AvatarStorage", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(mI), Boolean.valueOf(z), str2);
                            newChannel.close();
                            openRead.close();
                            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(allocateDirect);
                            if (!z) {
                                return createBitmap;
                            }
                            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                            x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", createBitmap.toString());
                            createBitmap.recycle();
                            return createBitmap2;
                        } catch (Exception e3) {
                            e = e3;
                            x.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                            if (newChannel != null) {
                                try {
                                    newChannel.close();
                                } catch (Exception e4) {
                                    return null;
                                }
                            }
                            if (openRead == null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        } catch (OutOfMemoryError e5) {
                            e2 = e5;
                            x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                            if (newChannel != null) {
                                try {
                                    newChannel.close();
                                } catch (Exception e42) {
                                    return null;
                                }
                            }
                            if (openRead == null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        newChannel = null;
                        x.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                        if (newChannel != null) {
                            try {
                                newChannel.close();
                            } catch (Exception e422) {
                                return null;
                            }
                        }
                        if (openRead == null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    } catch (OutOfMemoryError e7) {
                        e2 = e7;
                        newChannel = null;
                        x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                        if (newChannel != null) {
                            try {
                                newChannel.close();
                            } catch (Exception e4222) {
                                return null;
                            }
                        }
                        if (openRead == null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    }
                }
                x.d("MicroMsg.AvatarStorage", "SmallBM get bm file not exsit:%s", str2);
                return null;
            } catch (Exception e8) {
                e = e8;
                newChannel = null;
                openRead = null;
            } catch (OutOfMemoryError e9) {
                e2 = e9;
                newChannel = null;
                openRead = null;
                x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                if (newChannel != null) {
                    try {
                        newChannel.close();
                    } catch (Exception e42222) {
                        return null;
                    }
                }
                if (openRead == null) {
                    return null;
                }
                openRead.close();
                return null;
            }
        }

        static boolean eL(String str) {
            FileOp.deleteFile(str + ".bm");
            FileOp.deleteFile(str);
            return true;
        }
    }

    private class b implements com.tencent.mm.bs.b.a<Boolean> {
        private Runnable dHv;
        private CancellationSignal mCancellationSignal;

        private b() {
            this.dHv = new Runnable() {
                public final void run() {
                    e.b(f.this.dHk, "AvatarMigrate", 4);
                }
            };
        }

        /* synthetic */ b(f fVar, byte b) {
            this();
        }

        public final /* synthetic */ void aZ(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool.booleanValue() && this.mCancellationSignal == null) {
                this.mCancellationSignal = new CancellationSignal();
                f.this.dHk.mCancellationSignal = this.mCancellationSignal;
                g.Em().h(this.dHv, com.tencent.mm.sdk.a.b.chp() ? 60000 : 600000);
                x.d("MicroMsg.AvatarStorage", "Migration timer started.");
            } else if (!bool.booleanValue() && this.mCancellationSignal != null) {
                g.Em().cil().removeCallbacks(this.dHv);
                this.mCancellationSignal.cancel();
                this.mCancellationSignal = null;
                x.d("MicroMsg.AvatarStorage", "Migration timer cancelled.");
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        dHm = hashMap;
        hashMap.put("voipapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_voip));
        dHm.put("qqmail", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_qqmail));
        dHm.put("fmessage", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_fmessage));
        dHm.put("floatbottle", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_bottle));
        dHm.put("lbsapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_nearby));
        dHm.put("shakeapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_shake));
        dHm.put("medianote", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_medianote));
        dHm.put("qqfriend", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_qqfriend));
        dHm.put("masssendapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_masssend));
        dHm.put("feedsapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_feedsapp));
        dHm.put("facebookapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_facebookapp));
        dHm.put("newsapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_readerapp));
        dHm.put("helper_entry", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_plugin_icon_contract));
        dHm.put("voicevoipapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_voicevoip));
        dHm.put("voiceinputapp", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_voiceinput));
        dHm.put("officialaccounts", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_brand_contact));
        dHm.put("service_officialaccounts", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_servicebrand_contact));
        dHm.put("linkedinplugin", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_linkedin));
        dHm.put("notifymessage", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_notify_message_contact));
        dHm.put("appbrandcustomerservicemsg", Integer.valueOf(com.tencent.mm.plugin.comm.a.g.default_app_brand_service_msg));
    }

    public static void a(Context context, ImageView imageView, int i) {
        try {
            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), i), true, 1.0f));
        } catch (Throwable e) {
            x.e("MicroMsg.AvatarStorage", "exception:%s", bi.i(e));
        }
    }

    public f() {
        reset();
        this.dHn.a(this.dHp, null);
        this.dHk = new d();
        this.dHl = new a(new c(g.Ej().Dh(1)), g.Ej().Dh(0));
    }

    public final void a(c cVar) {
        synchronized (this.dHo) {
            this.dHo.add(new WeakReference(cVar));
        }
    }

    public final void b(c cVar) {
        synchronized (this.dHo) {
            this.dHo.remove(c(cVar));
        }
    }

    private WeakReference<c> c(c cVar) {
        synchronized (this.dHo) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dHo.size()) {
                    WeakReference<c> weakReference = (WeakReference) this.dHo.get(i2);
                    if (weakReference != null) {
                        c cVar2 = (c) weakReference.get();
                        if (cVar2 != null && cVar2.equals(cVar)) {
                            return weakReference;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return null;
                }
            }
        }
    }

    @Deprecated
    public final void d(c cVar) {
        this.dHn.a(cVar, Looper.getMainLooper());
    }

    @Deprecated
    public final void e(c cVar) {
        this.dHn.remove(cVar);
    }

    public static void reset() {
        if (dHq == null) {
            dHq = new a(dHj);
        }
    }

    final void Kt() {
        this.dHl.a(new b(this, (byte) 0));
    }

    public static Bitmap jS(String str) {
        if (bi.oW(str)) {
            return null;
        }
        a aVar = dHq;
        Bitmap bitmap = aVar.dGD != null ? (Bitmap) aVar.dGD.get(str) : (Bitmap) com.tencent.mm.cache.e.a.E("avatar_cache", str);
        if (bitmap == null) {
            return null;
        }
        if (!bitmap.isRecycled()) {
            return bitmap;
        }
        aVar = dHq;
        if (aVar.dGD != null) {
            aVar.dGD.remove(str);
        } else {
            com.tencent.mm.cache.e.a.F("avatar_cache", str);
        }
        return null;
    }

    public final void e(String str, Bitmap bitmap) {
        a aVar = dHq;
        if (aVar.dGD != null) {
            aVar.dGD.m(str, bitmap);
        } else {
            com.tencent.mm.cache.e.a.a("avatar_cache", str, bitmap);
        }
        this.dHn.ci(str);
        this.dHn.doNotify();
        x.d("MicroMsg.AvatarStorage", "setToCache %s", str);
    }

    public final Bitmap bJ(Context context) {
        context.getResources();
        Bitmap jS = jS("I_AM_NO_SDCARD_USER_NAME");
        if (q(jS) || jS == null) {
            return jS;
        }
        x.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", Boolean.valueOf(jS.isRecycled()), "I_AM_NO_SDCARD_USER_NAME");
        jS = com.tencent.mm.sdk.platformtools.c.a(jS, true, 1.0f);
        e("I_AM_NO_SDCARD_USER_NAME", jS);
        return jS;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c(java.lang.String r9, boolean r10, boolean r11) {
        /*
        r8 = this;
        r2 = 0;
        r5 = 47;
        r7 = 0;
        r6 = 2;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r9);
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        r0 = r2;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r9.getBytes();
        r1 = com.tencent.mm.a.g.u(r0);
        r3 = new java.lang.StringBuilder;
        r0 = "user_";
        r3.<init>(r0);
        if (r10 == 0) goto L_0x00fa;
    L_0x001f:
        r0 = "hd_";
    L_0x0022:
        r0 = r3.append(r0);
        r0 = r0.append(r1);
        r3 = ".png";
        r0 = r0.append(r3);
        r3 = r0.toString();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = r1.substring(r7, r6);
        r0 = r0.append(r4);
        r0 = r0.append(r5);
        r4 = 4;
        r1 = r1.substring(r6, r4);
        r0 = r0.append(r1);
        r0 = r0.append(r5);
        r0 = r0.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = com.tencent.mm.kernel.g.Ei();
        r4 = r4.cachePath;
        r1 = r1.append(r4);
        r4 = "avatar/";
        r1 = r1.append(r4);
        r1 = r1.append(r0);
        r1 = r1.append(r3);
        r1 = r1.toString();
        if (r11 != 0) goto L_0x0105;
    L_0x007b:
        r4 = com.tencent.mm.modelsfs.FileOp.cn(r1);
        if (r4 != 0) goto L_0x0105;
    L_0x0081:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.mm.kernel.g.Ei();
        r5 = r5.dqp;
        r4 = r4.append(r5);
        r5 = "avatar/";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r0 = r0.append(r3);
        r0 = r0.toString();
        r4 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r4 == 0) goto L_0x0105;
    L_0x00a9:
        r1 = new java.io.File;
        r1.<init>(r0);
        r1 = r1.getParent();
        r1 = com.tencent.mm.modelsfs.FileOp.mL(r1);
        if (r1 == 0) goto L_0x0102;
    L_0x00b8:
        r1 = r8.dHk;
        r4 = java.lang.System.currentTimeMillis();
        r2 = java.lang.Long.valueOf(r4);
        r4 = "MicroMsg.AvatarMigration";
        r5 = "Touch file: %s => %d";
        r6 = new java.lang.Object[r6];
        r6[r7] = r3;
        r7 = 1;
        r6[r7] = r2;
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);
        r4 = r1.dGH;
        monitor-enter(r4);
        r5 = r1.dGI;	 Catch:{ all -> 0x00ff }
        r5 = r5.isEmpty();	 Catch:{ all -> 0x00ff }
        r6 = r1.dGI;	 Catch:{ all -> 0x00ff }
        r6.put(r3, r2);	 Catch:{ all -> 0x00ff }
        monitor-exit(r4);	 Catch:{ all -> 0x00ff }
        if (r5 == 0) goto L_0x000c;
    L_0x00e3:
        r2 = "MicroMsg.AvatarMigration";
        r3 = "Enqueue cache flusher task.";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = com.tencent.mm.kernel.g.Em();
        r1 = r1.dGK;
        r4 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r2.h(r1, r4);
        goto L_0x000c;
    L_0x00fa:
        r0 = "";
        goto L_0x0022;
    L_0x00ff:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00ff }
        throw r0;
    L_0x0102:
        r0 = r2;
        goto L_0x000c;
    L_0x0105:
        r0 = r1;
        goto L_0x00a9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aa.f.c(java.lang.String, boolean, boolean):java.lang.String");
    }

    public static boolean B(String str, boolean z) {
        String aqI = com.tencent.mm.plugin.g.a.aqI();
        String a = h.a(aqI, "user_" + (z ? "hd_" : ""), com.tencent.mm.a.g.u(str.getBytes()), ".png", 1, false);
        aqI = g.Ei().dqp + "avatar/" + a.substring(aqI.length());
        x.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", str, Boolean.valueOf(z), a);
        boolean deleteFile = FileOp.deleteFile(aqI) | FileOp.deleteFile(a);
        if (z) {
            return deleteFile;
        }
        return deleteFile | d.eL(a);
    }

    public final Bitmap jT(String str) {
        return jW(c(str, false, false));
    }

    public final Bitmap f(String str, byte[] bArr) {
        Throwable e;
        Bitmap a = com.tencent.mm.sdk.platformtools.c.a(bArr, 96, 96, 0, 1);
        if (q(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
            OutputStream jx;
            try {
                jx = FileOp.jx(c(str, false, true));
                try {
                    jx.write(bArr, 0, bArr.length);
                    if (jx != null) {
                        try {
                            jx.close();
                        } catch (IOException e2) {
                        }
                    }
                    x.i("MicroMsg.AvatarStorage", "Saved avatar: %s", str);
                    return a;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (jx != null) {
                            try {
                                jx.close();
                            } catch (IOException e4) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (jx != null) {
                            try {
                                jx.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                jx = null;
                x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                if (jx != null) {
                    try {
                        jx.close();
                    } catch (IOException e42) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                jx = null;
                if (jx != null) {
                    try {
                        jx.close();
                    } catch (IOException e52) {
                    }
                }
                throw e;
            }
        }
        x.e("MicroMsg.AvatarStorage", "Failed to decode avatar: %s", str);
        return null;
    }

    public final boolean g(String str, byte[] bArr) {
        Bitmap f = f(str, bArr);
        if (!q(f)) {
            return false;
        }
        e(str, f);
        return true;
    }

    public final boolean ad(String str, String str2) {
        try {
            int i;
            int i2;
            Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(str);
            int i3 = VZ.outWidth;
            int i4 = VZ.outHeight;
            if (i4 < i3) {
                i = (i3 * 96) / i4;
                i2 = 96;
            } else {
                i2 = (i4 * 96) / i3;
                i = 96;
            }
            x.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1));
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            options.inSampleSize = Math.min(i3 / i, i4 / i2);
            return f(str2, com.tencent.mm.sdk.platformtools.c.a(str, options, 0, 0, 1));
        } catch (Throwable e) {
            x.e("MicroMsg.AvatarStorage", "exception:%s", bi.i(e));
            return false;
        }
    }

    final boolean f(String str, Bitmap bitmap) {
        Throwable e;
        OutputStream outputStream;
        if (!q(bitmap)) {
            return false;
        }
        Bitmap bitmap2;
        if (bitmap.getWidth() == 96 && bitmap.getHeight() == 96) {
            bitmap2 = bitmap;
        } else {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width != height) {
                    if (width > height) {
                        bitmap2 = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
                    } else {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
                    }
                    bitmap2 = Bitmap.createScaledBitmap(bitmap2, 96, 96, true);
                } else {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, 96, 96, true);
                }
            } catch (OutOfMemoryError e2) {
                x.e("MicroMsg.AvatarStorage", "kevin updateAvatar fail  %s ", str);
                if (q(bitmap)) {
                    x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                return false;
            }
        }
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            bitmap = bitmap2;
        }
        OutputStream outputStream2 = null;
        try {
            outputStream2 = FileOp.jx(c(str, false, true));
            try {
                bitmap.compress(CompressFormat.PNG, 100, outputStream2);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                e(str, bitmap);
                return true;
            } catch (IOException e4) {
                e = e4;
                outputStream = outputStream2;
                try {
                    x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = outputStream2;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e62) {
                    }
                }
                throw e;
            }
        } catch (IOException e7) {
            e = e7;
            outputStream = outputStream2;
        } catch (Throwable th3) {
            e = th3;
            outputStream = outputStream2;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e622) {
                }
            }
            throw e;
        }
    }

    public final Bitmap jU(String str) {
        x.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", str);
        if (bi.oW(str)) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.c.a(c(str, true, false), 480, 480, null, 0, 0, 1);
    }

    public static Bitmap jV(String str) {
        Bitmap decodeResource;
        int i = 0;
        if (dHm.containsKey(str)) {
            i = ((Integer) dHm.get(str)).intValue();
        }
        if (i != 0) {
            q.KG();
            decodeResource = com.tencent.mm.compatible.g.a.decodeResource(q.getContext().getResources(), i);
        } else {
            decodeResource = null;
        }
        return com.tencent.mm.sdk.platformtools.c.a(decodeResource, true, 1.0f, true);
    }

    private static boolean q(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public static Bitmap jW(String str) {
        Bitmap a = FileOp.cn(str) ? com.tencent.mm.sdk.platformtools.c.a(str, null, 0, 0, 1) : null;
        if (a == null) {
            a = d.jZ(str);
        }
        if (q(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
        }
        if (!q(a)) {
            return null;
        }
        String str2 = g.Ei().dqp + "avatar/";
        if (!str.startsWith(str2)) {
            return a;
        }
        e.b(new a(str, g.Ei().cachePath + "avatar/" + str.substring(str2.length())), "AvatarMigrate", 4);
        return a;
    }
}
