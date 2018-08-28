package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.network.b;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements com.tencent.mm.plugin.fts.a.d.c {
    private static int joL = 32;
    private ag dvh = new ag(Looper.getMainLooper());
    private ConcurrentHashMap<String, a> joM;
    private Vector<String> joN;
    private boolean joO = true;
    private int joP = 0;
    private ag[] joQ = new ag[2];
    private ConcurrentHashMap<Long, ByteArrayOutputStream> joR = null;
    private ConcurrentHashMap<Long, byte[]> joS = null;
    private ag joT = null;
    private Set<String> joU;

    interface c {
        void au(String str, boolean z);
    }

    static /* synthetic */ Bitmap Q(String str, int i, int i2) {
        if (bi.oW(str) || !new File(str).exists()) {
            return null;
        }
        return (i <= 0 || i2 <= 0) ? y.oQ(str) : y.o(str, i, i2);
    }

    static /* synthetic */ void a(c cVar, String str, String str2, Bitmap bitmap) {
        if (cVar.joM.size() > joL) {
            cVar.Ck((String) cVar.joN.lastElement());
        }
        a aVar = new a(cVar);
        aVar.bVd = str2;
        aVar.bitmap = bitmap;
        cVar.joM.put(str, aVar);
        if (!new File(aVar.bVd).exists()) {
            cVar.joT.postDelayed(new d(cVar, aVar), 200);
        }
    }

    public c() {
        int i = 0;
        x.i("MicroMsg.FTS.FTSImageLoader", "create SearchImageLoader");
        if (d.fR(19)) {
            joL = 64;
        } else {
            joL = 32;
        }
        this.joM = new ConcurrentHashMap();
        this.joN = new Vector();
        this.joR = new ConcurrentHashMap();
        this.joS = new ConcurrentHashMap();
        this.joU = Collections.synchronizedSet(new HashSet());
        while (i < 2) {
            if (this.joQ[i] == null) {
                e.d(new 1(this, i), "SearchImageLoader_loadImage_handler", 1).start();
            }
            i++;
        }
        e.d(new 2(this), "SearchImageLoader_saveImage_handler", 1).start();
    }

    public final void a(Context context, ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String a = a(imageView, str, str2, z, i, i2);
        if (this.joO) {
            b bVar = new b(this, a, str, str2, z, i, i2, new 3(this, imageView, context));
            if (this.joU.add(a)) {
                this.joP++;
                this.joP %= 2;
                this.joQ[this.joP].post(bVar);
                return;
            }
            x.v("MicroMsg.FTS.FTSImageLoader", "cacheKey: %s | runningJobTask: %s", new Object[]{a, this.joU.toString()});
        }
    }

    public final String a(ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String b = b(str, str2, z, i, i2);
        imageView.setTag(b);
        x.d("MicroMsg.FTS.FTSImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", new Object[]{Integer.valueOf(imageView.hashCode()), b});
        return b;
    }

    public final void aPL() {
        x.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImageTask");
        for (int i = 0; i < 2; i++) {
            if (this.joQ[i] != null) {
                this.joQ[i].removeCallbacksAndMessages(null);
            }
        }
    }

    public final void aPM() {
        x.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImage");
        this.joO = false;
        aPL();
    }

    public final boolean aPN() {
        return this.joO;
    }

    public final void aPO() {
        x.d("MicroMsg.FTS.FTSImageLoader", "startLoadImage");
        this.joO = true;
    }

    public final void aPP() {
        x.d("MicroMsg.FTS.FTSImageLoader", "clearCacheAndTask %s", new Object[]{Integer.valueOf(this.joM.size())});
        aPL();
        for (Entry key : this.joM.entrySet()) {
            Ck((String) key.getKey());
        }
        this.joN.clear();
        this.joU.clear();
    }

    public final void aPQ() {
        aPP();
        x.d("MicroMsg.FTS.FTSImageLoader", "destoryLoader");
        for (int i = 0; i < 2; i++) {
            if (this.joQ[i] != null) {
                this.joQ[i].getLooper().quit();
            }
        }
        for (ByteArrayOutputStream close : this.joR.values()) {
            try {
                close.close();
            } catch (IOException e) {
            }
        }
        this.joR.clear();
        this.joS.clear();
        this.joT.getLooper().quit();
    }

    public final Bitmap a(String str, String str2, boolean z, int i, int i2) {
        return ma(b(str, str2, z, i, i2));
    }

    private Bitmap ma(String str) {
        a aVar = (a) this.joM.get(str);
        if (!(aVar == null || aVar.bitmap == null || aVar.bitmap.isRecycled())) {
            this.joN.remove(str);
            this.joN.add(0, str);
        }
        return aVar == null ? null : aVar.bitmap;
    }

    private synchronized byte[] getBuffer() {
        byte[] bArr;
        bArr = (byte[]) this.joS.get(Long.valueOf(Thread.currentThread().getId()));
        if (bArr == null) {
            bArr = new byte[1024];
            this.joS.put(Long.valueOf(Thread.currentThread().getId()), bArr);
        }
        return bArr;
    }

    private static String b(String str, String str2, boolean z, int i, int i2) {
        return "fts_search_" + g.u((bi.aG(str, "null") + bi.aG(str2, "null") + z + i + "_" + i2).getBytes());
    }

    private Bitmap b(String str, boolean z, int i, int i2) {
        InputStream n;
        Throwable e;
        if (bi.oW(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.joR.get(Long.valueOf(Thread.currentThread().getId()));
        if (byteArrayOutputStream == null) {
            byteArrayOutputStream = new ByteArrayOutputStream(32768);
            this.joR.put(Long.valueOf(Thread.currentThread().getId()), byteArrayOutputStream);
        }
        byteArrayOutputStream.reset();
        byte[] buffer = getBuffer();
        try {
            n = b.n(str, 10000, 20000);
            if (n == null) {
                x.w("MicroMsg.FTS.FTSImageLoader", "download %s error, can not open http stream", new Object[]{str});
                if (n != null) {
                    try {
                        n.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e2, "", new Object[0]);
                    }
                }
                return null;
            }
            Bitmap bs;
            int i3 = 0;
            while (true) {
                try {
                    int read = n.read(buffer);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                    byteArrayOutputStream.write(buffer, 0, read);
                } catch (Exception e3) {
                    e2 = e3;
                }
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (i <= 0 || i2 <= 0) {
                bs = com.tencent.mm.sdk.platformtools.c.bs(toByteArray);
            } else {
                bs = com.tencent.mm.sdk.platformtools.c.decodeByteArray(toByteArray, i, i2);
            }
            x.d("MicroMsg.FTS.FTSImageLoader", "get url[%s] ok, bufSize[%d], bitmap size %d * %d", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(bs.getWidth()), Integer.valueOf(bs.getHeight())});
            if (z) {
                bs = com.tencent.mm.sdk.platformtools.c.a(bs, true, (float) bs.getWidth());
                if (n == null) {
                    return bs;
                }
                try {
                    n.close();
                    return bs;
                } catch (Throwable e4) {
                    x.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e4, "", new Object[0]);
                    return bs;
                }
            } else if (n == null) {
                return bs;
            } else {
                try {
                    n.close();
                    return bs;
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e42, "", new Object[0]);
                    return bs;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            n = null;
        } catch (Throwable th) {
            e2 = th;
            n = null;
            if (n != null) {
                try {
                    n.close();
                } catch (Throwable e422) {
                    x.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e422, "", new Object[0]);
                }
            }
            throw e2;
        }
        try {
            x.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e2, "", new Object[0]);
            x.w("MicroMsg.FTS.FTSImageLoader", "get url:%s failed.", new Object[]{str});
            if (n != null) {
                try {
                    n.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e22, "", new Object[0]);
                }
            }
            return null;
        } catch (Throwable th2) {
            e22 = th2;
            if (n != null) {
                try {
                    n.close();
                } catch (Throwable e4222) {
                    x.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e4222, "", new Object[0]);
                }
            }
            throw e22;
        }
        return null;
    }

    private void Ck(String str) {
        a aVar = (a) this.joM.get(str);
        this.joN.remove(str);
        this.joM.remove(str);
        if (aVar != null && aVar.bitmap != null) {
            if (!aVar.bitmap.isRecycled()) {
                x.i("MicroMsg.FTS.FTSImageLoader", "bitmap recycle %s", new Object[]{aVar.bitmap});
                aVar.bitmap.recycle();
            }
            aVar.bitmap = null;
        }
    }
}
