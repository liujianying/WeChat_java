package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.platformtools.w.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

enum y$b {
    ;
    
    private static DisplayMetrics ewi;
    private Map<String, c> ewe;
    private Map<String, WeakReference<Bitmap>> ewf;
    private at ewg;
    private at ewh;

    private y$b(String str) {
        this.ewe = new HashMap();
        this.ewf = new HashMap();
        this.ewg = null;
        this.ewh = null;
    }

    static {
        ewi = null;
    }

    private Bitmap d(w wVar) {
        Assert.assertTrue("picture strategy here must be validity", y.c(wVar));
        String Vw = wVar.Vw();
        c cVar = (c) this.ewe.get(Vw);
        if (cVar == null) {
            cVar = new c();
        }
        if (cVar.ewm) {
            if (cVar.ewn < 3) {
                cVar.ewn++;
            } else if (bi.bG((long) cVar.ewo) < 120) {
                x.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", new Object[]{Integer.valueOf(120), Vw});
                return null;
            } else {
                cVar.ewn = 0;
            }
            cVar.ewm = false;
            cVar.ewo = (int) bi.VE();
            this.ewe.put(Vw, cVar);
        } else if (bi.bG((long) cVar.ewo) < 120) {
            x.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", new Object[]{Integer.valueOf(120), Vw});
            return null;
        } else {
            cVar.ewn++;
            cVar.ewo = (int) bi.VE();
            this.ewe.put(Vw, cVar);
        }
        if (wVar.Vy()) {
            Bitmap oO;
            b Vu = wVar.Vu();
            if (Vu != null) {
                oO = Vu.oO(wVar.Vv());
            } else {
                oO = oQ(wVar.Vv());
            }
            if (oO != null) {
                oO = a(wVar, oO);
                this.ewe.remove(Vw);
                return oO;
            }
            if (this.ewg == null || this.ewg.ciz()) {
                this.ewg = new at(1, "readerapp-pic-logic-download", 3);
            }
            this.ewg.c(new a(wVar));
            return null;
        }
        if (this.ewh == null || this.ewh.ciz()) {
            this.ewh = new at(1, "readerapp-pic-logic-reader", 1);
        }
        this.ewh.c(new b(wVar));
        return null;
    }

    protected final Bitmap a(w wVar, Bitmap bitmap) {
        Assert.assertTrue("picture strategy here must be validity", y.c(wVar));
        if (bitmap != null) {
            Bitmap a = wVar.a(bitmap, a.ewa, wVar.Vv());
            if (!(a == bitmap || bitmap.isRecycled())) {
                x.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", new Object[]{bitmap.toString()});
                bitmap.recycle();
            }
            b(wVar, a);
            return a;
        }
        wVar.a(a.ewa, null);
        return bitmap;
    }

    private void b(w wVar, Bitmap bitmap) {
        Assert.assertTrue("picture strategy here must be validity", y.c(wVar));
        String cacheKey = wVar.getCacheKey();
        Bitmap bitmap2 = this.ewf.containsKey(cacheKey) ? (Bitmap) ((WeakReference) this.ewf.get(cacheKey)).get() : null;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            this.ewf.remove(cacheKey);
            this.ewf.put(cacheKey, new WeakReference(bitmap));
        }
    }

    public static Bitmap o(String str, int i, int i2) {
        Bitmap bitmap = null;
        if (bi.oW(str)) {
            x.w("MicroMsg.MMPictureLogic", "error input, path is null");
        } else if (i <= 0 || i2 <= 0) {
            x.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            bitmap = c.a(str, i, i2, decodeResultLogger, 0, new int[0]);
            if (bitmap == null && decodeResultLogger.getDecodeResult() >= 2000) {
                h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 8, decodeResultLogger));
            }
        }
        return bitmap;
    }

    public static Bitmap oQ(String str) {
        if (ewi == null) {
            ewi = ad.getContext().getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = ewi;
        return o(str, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static Bitmap oR(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.MMPictureLogic", "error input, path is null");
            return null;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        Bitmap a = c.a(str, 0, 0, decodeResultLogger, 0, new int[0]);
        if (a != null || decodeResultLogger.getDecodeResult() < 2000) {
            return a;
        }
        h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 8, decodeResultLogger));
        return a;
    }
}
