package com.tencent.mm.modelsfs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class FileOp {
    private static TreeMap<String, SFSContextRec> eeA = new TreeMap();
    private static File eeB;
    private static String eeC = "";
    private static final EnumSet<com.tencent.mm.modelsfs.g.a> eeD = EnumSet.of(com.tencent.mm.modelsfs.g.a.PATHNAME, com.tencent.mm.modelsfs.g.a.PERIOD);
    private static ReentrantReadWriteLock eez = new ReentrantReadWriteLock();

    static class SFSContextRec implements Parcelable {
        public static final Creator<SFSContextRec> CREATOR = new Creator<SFSContextRec>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SFSContextRec(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SFSContextRec[i];
            }
        };
        String eeG;
        String[] eeH;
        boolean eeI;
        boolean eeJ;
        SFSContext eeK;
        Builder eeL;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.eeG);
            parcel.writeStringArray(this.eeH);
            parcel.writeByte((byte) (this.eeI ? 1 : 0));
            parcel.writeParcelable(this.eeL, i);
        }

        SFSContextRec(Parcel parcel) {
            boolean z;
            this.eeG = parcel.readString();
            this.eeH = parcel.createStringArray();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.eeI = z;
            this.eeK = null;
            this.eeJ = false;
            this.eeL = (Builder) parcel.readParcelable(Builder.class.getClassLoader());
        }
    }

    class a {
        File eeE;
        File[] eeF = null;
        int pos = 0;

        a(File file) {
            this.eeE = file;
        }
    }

    public static void init(boolean z) {
        Context context = ad.getContext();
        eeB = new File(context.getFilesDir(), "fileop_mapping");
        eeC = ax.Wz(b.bnC);
        if (z) {
            eeB.delete();
            return;
        }
        x.i("MicroMsg.FileOp", "Initializing FileOp mapping slave.");
        if (eeB.exists()) {
            byte[] e = e(eeB.getAbsolutePath(), 0, -1);
            if (e != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(e, 0, e.length);
                obtain.setDataPosition(0);
                Bundle readBundle = obtain.readBundle(SFSContextRec.class.getClassLoader());
                obtain.recycle();
                eez.writeLock().lock();
                for (String str : readBundle.keySet()) {
                    SFSContextRec sFSContextRec = (SFSContextRec) eeA.put(str, (SFSContextRec) readBundle.getParcelable(str));
                    if (!(sFSContextRec == null || sFSContextRec.eeK == null)) {
                        sFSContextRec.eeK.release();
                    }
                    x.i("MicroMsg.FileOp", "Load mapping from file: " + str);
                }
                eez.writeLock().unlock();
            }
        }
        BroadcastReceiver anonymousClass1 = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                SFSContextRec sFSContextRec;
                if (intent.getAction().equals("com.tencent.mm.FileOp.registerSFS")) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("rec");
                    if (byteArrayExtra != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                        obtain.setDataPosition(0);
                        sFSContextRec = (SFSContextRec) SFSContextRec.CREATOR.createFromParcel(obtain);
                        if (sFSContextRec != null) {
                            String str = sFSContextRec.eeG;
                            FileOp.eez.writeLock().lock();
                            sFSContextRec = (SFSContextRec) FileOp.eeA.put(str, sFSContextRec);
                            FileOp.eez.writeLock().unlock();
                            if (!(sFSContextRec == null || sFSContextRec.eeK == null)) {
                                sFSContextRec.eeK.release();
                            }
                            x.i("MicroMsg.FileOp", "Load mapping from broadcast: " + str);
                            obtain.recycle();
                        }
                    }
                } else if (intent.getAction().equals("com.tencent.mm.FileOp.unregisterSFS")) {
                    String stringExtra = intent.getStringExtra("prefix");
                    FileOp.eez.writeLock().lock();
                    sFSContextRec = (SFSContextRec) FileOp.eeA.remove(stringExtra);
                    FileOp.eez.writeLock().unlock();
                    if (!(sFSContextRec == null || sFSContextRec.eeK == null)) {
                        sFSContextRec.eeK.release();
                    }
                    x.i("MicroMsg.FileOp", "Unload mapping from broadcast: " + stringExtra);
                } else if (intent.getAction().equals("com.tencent.mm.FileOp.clearSFS")) {
                    FileOp.eez.writeLock().lock();
                    for (SFSContextRec sFSContextRec2 : FileOp.eeA.values()) {
                        if (!(sFSContextRec2 == null || sFSContextRec2.eeK == null)) {
                            sFSContextRec2.eeK.release();
                        }
                    }
                    FileOp.eeA.clear();
                    FileOp.eez.writeLock().unlock();
                    x.i("MicroMsg.FileOp", "Clear mapping from broadcast.");
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.FileOp.registerSFS");
        intentFilter.addAction("com.tencent.mm.FileOp.unregisterSFS");
        intentFilter.addAction("com.tencent.mm.FileOp.clearSFS");
        context.registerReceiver(anonymousClass1, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
    }

    private static void QG() {
        Bundle bundle = new Bundle();
        eez.readLock().lock();
        for (SFSContextRec sFSContextRec : eeA.values()) {
            bundle.putParcelable(sFSContextRec.eeG, sFSContextRec);
        }
        eez.readLock().unlock();
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        String absolutePath = eeB.getAbsolutePath();
        byte[] marshall = obtain.marshall();
        b(absolutePath, marshall, marshall.length);
        obtain.recycle();
    }

    public static void a(String str, Builder builder) {
        SFSContextRec sFSContextRec = null;
        if (builder == null) {
            mC(str);
        } else if (eeC.toLowerCase().contains("fat")) {
            x.i("MicroMsg.FileOp", "SFS enabled on file system '%s'", eeC);
            if (new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/disable-sfs").exists()) {
                x.i("MicroMsg.FileOp", "SFS disabled.");
                return;
            }
            SFSContextRec sFSContextRec2;
            if (builder != null) {
                sFSContextRec2 = new SFSContextRec();
                sFSContextRec2.eeG = str;
                sFSContextRec2.eeH = null;
                sFSContextRec2.eeI = false;
                sFSContextRec2.eeK = null;
                sFSContextRec2.eeL = builder;
                sFSContextRec = sFSContextRec2;
            }
            eez.writeLock().lock();
            sFSContextRec2 = (SFSContextRec) eeA.put(str, sFSContextRec);
            eez.writeLock().unlock();
            if (!(sFSContextRec2 == null || sFSContextRec2.eeK == null)) {
                sFSContextRec2.eeK.release();
            }
            Parcel obtain = Parcel.obtain();
            sFSContextRec.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            Context context = ad.getContext();
            context.sendBroadcast(new Intent("com.tencent.mm.FileOp.registerSFS").putExtra("rec", marshall).setPackage(context.getPackageName()), "com.tencent.mm.permission.MM_MESSAGE");
            QG();
            x.i("MicroMsg.FileOp", "Register SFS for prefix: " + str);
        } else {
            x.i("MicroMsg.FileOp", "SFS disabled on file system '%s'", eeC);
        }
    }

    public static void mC(String str) {
        eez.writeLock().lock();
        SFSContextRec sFSContextRec = (SFSContextRec) eeA.remove(str);
        eez.writeLock().unlock();
        if (!(sFSContextRec == null || sFSContextRec.eeK == null)) {
            sFSContextRec.eeK.release();
        }
        Context context = ad.getContext();
        context.sendBroadcast(new Intent("com.tencent.mm.FileOp.unregisterSFS").putExtra("prefix", str).setPackage(context.getPackageName()), "com.tencent.mm.permission.MM_MESSAGE");
        QG();
        x.i("MicroMsg.FileOp", "Unregister SFS for prefix: " + str);
    }

    public static Map<String, Statistics> QH() {
        eez.readLock().lock();
        Map treeMap = new TreeMap();
        for (SFSContextRec sFSContextRec : eeA.values()) {
            if (!(sFSContextRec == null || sFSContextRec.eeJ)) {
                if (sFSContextRec.eeK == null) {
                    synchronized (sFSContextRec) {
                        if (sFSContextRec.eeK == null) {
                            try {
                                sFSContextRec.eeK = sFSContextRec.eeL.create();
                            } catch (Exception e) {
                                x.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.eeG, e.getMessage());
                                sFSContextRec.eeJ = true;
                            }
                        }
                    }
                }
                SFSContext sFSContext = sFSContextRec.eeK;
                if (sFSContext.mNativePtr == 0) {
                    throw new IllegalArgumentException("Reuse already released SFSContext.");
                }
                treeMap.put(sFSContextRec.eeL.mName, SFSContext.nativeStatistics(sFSContext.mNativePtr));
            }
        }
        eez.readLock().unlock();
        return treeMap;
    }

    private static boolean a(String str, SFSContextRec sFSContextRec) {
        if (sFSContextRec.eeH == null) {
            return false;
        }
        String substring = str.substring(sFSContextRec.eeG.length());
        int lastIndexOf = substring.lastIndexOf(47);
        if (lastIndexOf == -1) {
            return false;
        }
        String substring2 = substring.substring(lastIndexOf + 1);
        if (substring2.length() == 0) {
            return false;
        }
        for (String a : sFSContextRec.eeH) {
            if (g.a(a, 0, substring2, 0, eeD)) {
                return true;
            }
        }
        return false;
    }

    private static boolean mD(String str) {
        boolean z;
        eez.readLock().lock();
        Entry floorEntry = eeA.floorEntry(str);
        if (floorEntry != null && str.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (!(sFSContextRec.eeJ || sFSContextRec.eeH != null || sFSContextRec.eeI)) {
                z = false;
                eez.readLock().unlock();
                return z;
            }
        }
        z = true;
        eez.readLock().unlock();
        return z;
    }

    private static boolean mE(String str) {
        boolean z;
        eez.readLock().lock();
        Entry floorEntry = eeA.floorEntry(str);
        if (floorEntry != null && str.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (!(sFSContextRec.eeJ || a(str, sFSContextRec))) {
                z = false;
                eez.readLock().unlock();
                return z;
            }
        }
        z = true;
        eez.readLock().unlock();
        return z;
    }

    private static SFSContextRec mF(String str) {
        eez.readLock().lock();
        Entry floorEntry = eeA.floorEntry(str);
        if (floorEntry == null) {
            return null;
        }
        SFSContextRec sFSContextRec;
        if (str.startsWith((String) floorEntry.getKey())) {
            sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (a(str, sFSContextRec)) {
                sFSContextRec = null;
            }
        } else {
            sFSContextRec = null;
        }
        if (sFSContextRec == null || sFSContextRec.eeJ) {
            return null;
        }
        if (sFSContextRec.eeK != null) {
            return sFSContextRec;
        }
        synchronized (sFSContextRec) {
            if (sFSContextRec.eeK == null) {
                try {
                    sFSContextRec.eeK = sFSContextRec.eeL.create();
                } catch (Exception e) {
                    x.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.eeG, e.getMessage());
                    sFSContextRec.eeJ = true;
                    return null;
                }
            }
        }
        return sFSContextRec;
    }

    public static java.io.InputStream openRead(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.modelsfs.FileOp.openRead(java.lang.String):java.io.InputStream, dom blocks: [B:7:0x0017, B:21:0x0062]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:89)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Unknown Source)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        if (r7 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r7.length();
        if (r0 != 0) goto L_0x0011;
    L_0x0008:
        r0 = new java.io.FileNotFoundException;
        r1 = "path == null";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r1 = mF(r7);
        if (r1 != 0) goto L_0x0062;
    L_0x0017:
        r0 = com.tencent.mm.modelsfs.f.mP(r7);	 Catch:{ all -> 0x0057 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0057 }
    L_0x001d:
        r2 = com.tencent.mm.modelsfs.f.mR(r7);	 Catch:{ all -> 0x0057 }
        r4 = com.tencent.mm.modelsfs.f.mQ(r7);	 Catch:{ all -> 0x0057 }
        r0 = new com.tencent.mm.modelsfs.b;	 Catch:{ all -> 0x0057 }
        r0.<init>(r4, r2);	 Catch:{ all -> 0x0057 }
    L_0x002a:
        r2 = eez;
        r2 = r2.readLock();
        r2.unlock();
        r2 = "MicroMsg.FileOp";
        r3 = "openRead: %s [%s, %s]";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r7;
        r5 = 1;
        r6 = "ok";
        r4[r5] = r6;
        r5 = 2;
        if (r1 != 0) goto L_0x007f;
    L_0x0048:
        r1 = "regular";
    L_0x004b:
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);
        return r0;
    L_0x0051:
        r0 = new java.io.FileInputStream;	 Catch:{ all -> 0x0057 }
        r0.<init>(r7);	 Catch:{ all -> 0x0057 }
        goto L_0x002a;
    L_0x0057:
        r0 = move-exception;
        r1 = eez;
        r1 = r1.readLock();
        r1.unlock();
        throw r0;
    L_0x0062:
        r0 = r1.eeG;	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r0.length();	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r7.substring(r0);	 Catch:{ FileNotFoundException -> 0x0073 }
        r2 = r1.eeK;	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r2.openRead(r0);	 Catch:{ FileNotFoundException -> 0x0073 }
        goto L_0x002a;
    L_0x0073:
        r0 = move-exception;
        r2 = r1.eeI;	 Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x0079;	 Catch:{ all -> 0x0057 }
    L_0x0078:
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x0079:
        r0 = new java.io.FileInputStream;	 Catch:{ all -> 0x0057 }
        r0.<init>(r7);	 Catch:{ all -> 0x0057 }
        goto L_0x002a;
    L_0x007f:
        r1 = "SFS";
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsfs.FileOp.openRead(java.lang.String):java.io.InputStream");
    }

    public static OutputStream jx(String str) {
        return mG(str);
    }

    public static OutputStream mG(String str) {
        if (str == null || str.length() == 0) {
            throw new FileNotFoundException("path == null");
        }
        String str2 = "";
        if (f.mP(str)) {
            str2 = f.mS(str);
            str = f.mQ(str);
        }
        return au(str, str2);
    }

    private static OutputStream au(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new FileNotFoundException("path == null");
        }
        OutputStream fileOutputStream;
        SFSContextRec mF = mF(str);
        if (mF == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    fileOutputStream = new FileOutputStream(str);
                } else {
                    fileOutputStream = new c(str, str2);
                }
            } catch (Throwable th) {
                eez.readLock().unlock();
            }
        } else {
            fileOutputStream = mF.eeK.aw(str.substring(mF.eeG.length()), str2);
        }
        eez.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "openWrite: %s [%s, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = "ok";
        objArr[2] = mF == null ? "regular" : "SFS";
        x.d(str3, str4, objArr);
        return fileOutputStream;
    }

    public static boolean mH(String str) {
        InputStream openRead;
        OutputStream fileOutputStream;
        IOException e;
        Throwable th;
        if (str == null || str.length() == 0) {
            return false;
        }
        SFSContextRec mF = mF(str);
        if (mF == null) {
            eez.readLock().unlock();
            return true;
        }
        try {
            openRead = mF.eeK.openRead(str.substring(mF.eeG.length()));
            try {
                String parent = new File(str).getParent();
                if (!bi.oW(parent)) {
                    new File(parent).mkdirs();
                }
                fileOutputStream = new FileOutputStream(str);
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
                try {
                    x.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    eez.readLock().unlock();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    eez.readLock().unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e52) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e62) {
                    }
                }
                eez.readLock().unlock();
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openRead.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e7) {
                        }
                    }
                }
                openRead.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                }
                eez.readLock().unlock();
                return true;
            } catch (IOException e9) {
                e = e9;
                x.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e32) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e42) {
                    }
                }
                eez.readLock().unlock();
                return false;
            }
        } catch (IOException e10) {
            e = e10;
            fileOutputStream = null;
            openRead = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            openRead = null;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e522) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e622) {
                }
            }
            eez.readLock().unlock();
            throw th;
        }
    }

    public static long mI(String str) {
        long j = 0;
        if (str != null) {
            String str2;
            SFSContextRec mF = mF(str);
            String mQ;
            if (mF != null) {
                FileEntry mU = mF.eeK.mU(str.substring(mF.eeG.length()));
                if (mU != null) {
                    j = mU.size;
                } else if (mF.eeI) {
                    if (f.mP(str)) {
                        mQ = f.mQ(str);
                    } else {
                        mQ = str;
                    }
                    j = new File(mQ).length();
                }
            } else {
                if (f.mP(str)) {
                    mQ = f.mQ(str);
                } else {
                    mQ = str;
                }
                j = new File(mQ).length();
            }
            eez.readLock().unlock();
            String str3 = "MicroMsg.FileOp";
            String str4 = "readFileLength: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            if (mF == null) {
                str2 = "regular";
            } else {
                str2 = "SFS";
            }
            objArr[2] = str2;
            x.d(str3, str4, objArr);
        }
        return j;
    }

    public static long mJ(String str) {
        long j = 0;
        if (!(str == null || str.length() == 0)) {
            String str2;
            SFSContextRec mF = mF(str);
            if (mF != null) {
                FileEntry mU = mF.eeK.mU(str.substring(mF.eeG.length()));
                if (mU != null) {
                    j = mU.timestamp * 1000;
                } else if (mF.eeI) {
                    j = new File(str).lastModified();
                }
            } else {
                j = new File(str).lastModified();
            }
            eez.readLock().unlock();
            String str3 = "MicroMsg.FileOp";
            String str4 = "getFileTime: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            if (mF == null) {
                str2 = "regular";
            } else {
                str2 = "SFS";
            }
            objArr[2] = str2;
            x.d(str3, str4, objArr);
        }
        return j;
    }

    public static byte[] e(String str, int i, int i2) {
        IOException e;
        Throwable th;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 < 0 ? 2048 : i2);
        InputStream openRead;
        try {
            openRead = openRead(str);
            if (i > 0) {
                try {
                    openRead.skip((long) i);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.FileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e3) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
            }
            byte[] bArr = new byte[1024];
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            while (true) {
                int read = openRead.read(bArr, 0, Math.min(i2, 1024));
                if (read != -1 && i2 > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    i2 -= read;
                } else if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e5) {
                    }
                }
            }
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e52) {
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
            }
            x.d("MicroMsg.FileOp", "readFromFile: %s [%d]", str, Integer.valueOf(bArr.length));
            return bArr;
        } catch (IOException e7) {
            e = e7;
            openRead = null;
        } catch (Throwable th3) {
            th = th3;
            openRead = null;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
    }

    public static String ct(String str) {
        IOException e;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(openRead(str));
            try {
                char[] cArr = new char[512];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringBuilder.append(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                        }
                    }
                }
                inputStreamReader.close();
                return stringBuilder.toString();
            } catch (IOException e3) {
                e = e3;
                try {
                    x.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamReader = null;
            x.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            throw e;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
    }

    public static int l(String str, byte[] bArr) {
        return b(str, bArr, bArr.length);
    }

    public static int b(String str, byte[] bArr, int i) {
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i + 0) {
            return -3;
        }
        OutputStream outputStream = null;
        try {
            outputStream = mG(str);
            outputStream.write(bArr, 0, i);
            if (outputStream == null) {
                return 0;
            }
            try {
                outputStream.close();
                return 0;
            } catch (IOException e) {
                return 0;
            }
        } catch (IOException e2) {
            x.e("MicroMsg.FileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    public static String mK(String str) {
        return new File(f.mQ(str)).getParentFile().getAbsolutePath();
    }

    public static boolean mL(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String mQ = f.mQ(str);
        if (!mD(mQ)) {
            return true;
        }
        File file = new File(mQ);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static long y(String str, String str2) {
        InputStream openRead;
        IOException e;
        OutputStream outputStream;
        Throwable th;
        OutputStream outputStream2 = null;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        long j = 0;
        try {
            openRead = openRead(str);
            try {
                outputStream2 = mG(str2);
            } catch (IOException e2) {
                e = e2;
                outputStream = outputStream2;
                try {
                    x.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e52) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e62) {
                    }
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openRead.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream2.write(bArr, 0, read);
                    j += (long) read;
                }
                x.d("MicroMsg.FileOp", "copyFile: %s -> %s", str, str2);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e7) {
                    }
                }
                if (outputStream2 == null) {
                    return j;
                }
                try {
                    outputStream2.close();
                    return j;
                } catch (IOException e8) {
                    return j;
                }
            } catch (IOException e9) {
                e = e9;
                outputStream = outputStream2;
                x.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e32) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e42) {
                    }
                }
                return -1;
            } catch (Throwable th4) {
                th = th4;
                outputStream = outputStream2;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e522) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e622) {
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            outputStream = outputStream2;
            openRead = outputStream2;
        } catch (Throwable th5) {
            th = th5;
            outputStream = outputStream2;
            openRead = outputStream2;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e5222) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6222) {
                }
            }
            throw th;
        }
    }

    public static boolean cn(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean nativeExists;
        String str2;
        SFSContextRec mF = mF(str);
        if (mF != null) {
            SFSContext sFSContext = mF.eeK;
            String substring = str.substring(mF.eeG.length());
            if (sFSContext.mNativePtr == 0) {
                throw new IllegalArgumentException("Reuse already released SFSContext.");
            }
            if (f.mP(substring)) {
                f.mR(substring);
                substring = f.mQ(substring);
            }
            nativeExists = SFSContext.nativeExists(sFSContext.mNativePtr, substring);
            if (!nativeExists && mF.eeI) {
                nativeExists = new File(str).exists();
            }
        } else {
            nativeExists = new File(str).exists();
        }
        eez.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "fileExists: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(nativeExists);
        if (mF == null) {
            str2 = "regular";
        } else {
            str2 = "SFS";
        }
        objArr[2] = str2;
        x.d(str3, str4, objArr);
        return nativeExists;
    }

    public static boolean deleteFile(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean jy;
        String str2;
        SFSContextRec mF = mF(str);
        String mQ;
        if (mF != null) {
            jy = mF.eeK.jy(str.substring(mF.eeG.length()));
            if (!jy && mF.eeI) {
                if (f.mP(str)) {
                    mQ = f.mQ(str);
                } else {
                    mQ = str;
                }
                jy = new File(mQ).delete();
            }
        } else {
            if (f.mP(str)) {
                mQ = f.mQ(str);
            } else {
                mQ = str;
            }
            jy = new File(mQ).delete();
        }
        eez.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "deleteFile: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(jy);
        if (mF == null) {
            str2 = "regular";
        } else {
            str2 = "SFS";
        }
        objArr[2] = str2;
        x.d(str3, str4, objArr);
        return jy;
    }

    public static boolean i(String str, String str2, String str3) {
        return av(str + str2, str + str3);
    }

    public static boolean av(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (mE(str) && mE(str2)) {
            if (f.mP(str)) {
                str = f.mQ(str);
            }
            if (f.mP(str2)) {
                str2 = f.mQ(str2);
            }
            if (new File(str).renameTo(new File(str2))) {
                return true;
            }
        }
        if (y(str, str2) < 0) {
            return false;
        }
        deleteFile(str);
        return true;
    }

    public static List<FileEntry> H(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        List<FileEntry> arrayList;
        SFSContextRec mF = mF(str);
        if (mF != null) {
            str = str.substring(mF.eeG.length());
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            try {
                List<FileEntry> mT = mF.eeK.mT(str);
                arrayList = new ArrayList();
                for (FileEntry fileEntry : mT) {
                    if (fileEntry.name.substring(str.length()).indexOf(47) == -1) {
                        arrayList.add(fileEntry);
                    }
                }
                for (FileEntry fileEntry2 : arrayList) {
                    fileEntry2.name = mF.eeG + fileEntry2.name;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FileOp", e, "listFiles failed with SFS: " + str, new Object[0]);
                arrayList = new ArrayList();
            }
        } else {
            arrayList = new ArrayList();
        }
        if (mF == null || mF.eeH != null || mF.eeI) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new File(str));
            do {
                File[] listFiles = ((File) arrayDeque.pop()).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.isFile()) {
                            FileEntry fileEntry3 = new FileEntry();
                            fileEntry3.name = file.getAbsolutePath();
                            if (z) {
                                fileEntry3.size = file.length();
                                fileEntry3.timestamp = file.lastModified();
                            }
                            arrayList.add(fileEntry3);
                        } else {
                            file.isDirectory();
                        }
                    }
                }
            } while (!arrayDeque.isEmpty());
            eez.readLock().unlock();
            x.d("MicroMsg.FileOp", "listFiles: %s [%d]", str, Integer.valueOf(arrayList.size()));
            return arrayList;
        }
        eez.readLock().unlock();
        x.d("MicroMsg.FileOp", "listFiles: %s [%d]", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public static boolean I(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean z2;
        SFSContextRec mF = mF(str);
        if (mF != null) {
            try {
                if (str.equals(mF.eeG)) {
                    SFSContext sFSContext = mF.eeK;
                    if (sFSContext.mNativePtr == 0) {
                        throw new IllegalArgumentException("Reuse already released SFSContext.");
                    } else if (SFSContext.nativeClear(sFSContext.mNativePtr) != 0) {
                        throw new IOException(SFSContext.nativeErrorMessage());
                    }
                }
                for (FileEntry fileEntry : mF.eeK.mT(str.substring(mF.eeG.length()))) {
                    mF.eeK.jy(fileEntry.name);
                }
                z2 = true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FileOp", e, "deleteDirIncludedFiles failed: " + str, new Object[0]);
                z2 = false;
            }
        } else {
            File file = new File(str);
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new a(file));
            do {
                a aVar = (a) arrayDeque.getLast();
                if (aVar.eeF == null) {
                    aVar.eeF = aVar.eeE.listFiles();
                }
                if (aVar.eeF != null) {
                    File[] fileArr = aVar.eeF;
                    for (int i = aVar.pos; i < fileArr.length; i++) {
                        File file2 = fileArr[i];
                        if (file2.isFile()) {
                            file2.delete();
                        } else if (file2.isDirectory()) {
                            aVar.pos = i;
                            arrayDeque.add(new a(file2));
                            break;
                        }
                    }
                    if (!z) {
                        aVar.eeE.delete();
                    }
                    arrayDeque.removeLast();
                } else if (!z) {
                    aVar.eeE.delete();
                }
            } while (!arrayDeque.isEmpty());
            z2 = true;
        }
        eez.readLock().unlock();
        return z2;
    }

    public static boolean mM(String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            return z;
        }
        if (!cn(str)) {
            try {
                try {
                    mG(str).close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                x.e("MicroMsg.FileOp", "createNewFile '%s' failed: %s", str, e2.getMessage());
                return z;
            }
        }
        return true;
    }

    public static void mN(String str) {
        if (str != null && str.length() != 0 && mD(str)) {
            try {
                new File(str, ".nomedia").createNewFile();
            } catch (IOException e) {
                x.e("MicroMsg.FileOp", "markNoMedia '%s' failed: %s", str, e.getMessage());
            }
        }
    }

    public static String mO(String str) {
        if (!cn(str)) {
            return null;
        }
        return g.u((str + "-" + mI(str)).getBytes());
    }
}
