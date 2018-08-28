package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class g {
    public byte[] dsN = new byte[0];
    ag dvh;
    private SparseArray<Bitmap> qSA;
    a<e> qSB;
    a<b> qSC;
    private boolean qSD = true;
    private a qSE = new 6(this);
    volatile boolean qSu = false;
    private HandlerThread qSv = e.Xs("ImageEngine_handlerThread" + System.currentTimeMillis());
    private ag qSw;
    public HashMap<String, ImageView> qSx = new HashMap();
    public HashMap<ImageView, String> qSy = new HashMap();
    c<String, Bitmap> qSz;

    public g(int i) {
        this.qSv.start();
        this.qSw = new ag(this.qSv.getLooper());
        this.dvh = new ag(Looper.getMainLooper());
        this.qSB = new 1(this, this.qSv.getLooper());
        this.qSC = new 2(this, Looper.getMainLooper());
        this.qSA = new SparseArray();
        this.qSz = new 3(this, i);
        y.b(this.qSE);
    }

    public final void destroy() {
        x.d("MicroMsg.ImageEngine", "do destroy");
        this.qSu = true;
        this.qSv.quit();
        y.c(this.qSE);
        SparseArray sparseArray = this.qSA;
        c cVar = this.qSz;
        this.qSA = new SparseArray();
        this.qSz = new 4(this);
        e.post(new 5(this, sparseArray, cVar), "ImageEngine_destroy_" + System.currentTimeMillis());
    }

    public w h(String str, String str2, int i, int i2) {
        return null;
    }

    private void a(ImageView imageView, int i) {
        if (i == 0) {
            d.d(imageView);
            return;
        }
        Bitmap bitmap = (Bitmap) this.qSA.get(i);
        if (bitmap == null) {
            bitmap = com.tencent.mm.compatible.g.a.decodeResource(imageView.getResources(), i);
            this.qSA.put(i, bitmap);
        }
        d.b(imageView, bitmap);
    }

    static String n(String str, String str2, int i, int i2) {
        return bi.aG(str, "null") + "_" + bi.aG(str2, "null") + "_" + i + "_" + i2;
    }

    public final void a(ImageView imageView, String[] strArr, String str, int i, int i2, int i3) {
        int i4 = 0;
        if (!this.qSD) {
            return;
        }
        if (this.qSu) {
            x.w("MicroMsg.ImageEngine", "on attach, isQuit, return");
        } else if (imageView == null) {
            x.w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
        } else if ((strArr == null || strArr.length <= 0) && bi.oW(str)) {
            x.w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
            a(imageView, i);
        } else {
            String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
            String n = n(str2, str, i2, i3);
            synchronized (this.dsN) {
                str2 = (String) this.qSy.get(imageView);
                if (str2 != null) {
                    this.qSx.remove(str2);
                }
                this.qSy.put(imageView, n);
            }
            Bitmap bitmap = (Bitmap) this.qSz.get(n);
            if (bitmap == null || bitmap.isRecycled()) {
                x.v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", new Object[]{n});
                if (strArr != null && strArr.length > 1) {
                    for (int i5 = 1; i5 < strArr.length; i5++) {
                        bitmap = (Bitmap) this.qSz.get(n(strArr[i5], str, i2, i3));
                        String str3 = "MicroMsg.ImageEngine";
                        String str4 = "get next render bmp, key[%s], result[%B]";
                        Object[] objArr = new Object[2];
                        objArr[0] = n;
                        objArr[1] = Boolean.valueOf(bitmap != null);
                        x.v(str3, str4, objArr);
                        if (bitmap != null) {
                            d.b(imageView, bitmap);
                            i4 = 1;
                            break;
                        }
                    }
                }
                if (i4 == 0) {
                    x.v("MicroMsg.ImageEngine", "use default res to render");
                    a(imageView, i);
                }
                synchronized (this.dsN) {
                    this.qSx.put(n, imageView);
                }
                b bVar = (b) this.qSC.cfq();
                b.a(bVar, strArr);
                b.a(bVar, str);
                b.b(bVar, n);
                b.a(bVar, i2);
                b.b(bVar, i3);
                this.qSw.postAtFrontOfQueueV2(bVar);
                return;
            }
            d.b(imageView, bitmap);
        }
    }
}
