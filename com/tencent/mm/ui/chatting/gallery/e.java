package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.gallery.f.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class e implements android.support.v4.view.ViewPager.e {
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static long tVe = 0;
    private at dMA = new at(1, "chatting-image-gallery-lazy-loader");
    private ag dvh = new ag();
    private int if = 0;
    SparseArray<WeakReference<View>> jDo = new SparseArray();
    HashMap<String, Integer> jDp = new HashMap();
    SparseArray<String> jDq = new SparseArray();
    SparseArray<Bitmap> jDr = new SparseArray();
    protected f<String, Bitmap> jDs = new f(5, new 2(this));
    protected SparseIntArray jDt = new SparseIntArray();
    private boolean jDv = false;
    private int jDz = -1;
    LinkedList<String> qD = new LinkedList();
    SparseArray<String> tVb = new SparseArray();
    a tVc;
    protected f<Integer, Bitmap> tVd = new f(40, new 1(this));
    private LinkedList<Integer> tVf = new LinkedList();
    LinkedList<Integer> tVg = new LinkedList();
    Bitmap tVh;

    protected final void u(String str, Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            long width = ((long) bitmap.getWidth()) * ((long) bitmap.getHeight());
            if (mScreenHeight == 0 || mScreenWidth == 0) {
                mScreenWidth = ad.getContext().getResources().getDisplayMetrics().widthPixels;
                mScreenHeight = ad.getContext().getResources().getDisplayMetrics().heightPixels;
                tVe = ((long) mScreenWidth) * tVe;
            }
            if (width > tVe * 2) {
                i = 1;
                if (i == 0) {
                    x.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
                }
                this.jDs.m(str, bitmap);
                if (a.tVr.jDs.bb(str)) {
                    x.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                    try {
                        a.tVr.jDs.m(str, bitmap);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", e, "update preload cache failed", new Object[0]);
                        return;
                    }
                }
                return;
            }
        }
        i = 0;
        if (i == 0) {
            this.jDs.m(str, bitmap);
            if (a.tVr.jDs.bb(str)) {
                x.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                try {
                    a.tVr.jDs.m(str, bitmap);
                    return;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", e2, "update preload cache failed", new Object[0]);
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
    }

    public final void ay(Map<String, Bitmap> map) {
        for (String str : map.keySet()) {
            Bitmap bitmap = (Bitmap) map.get(str);
            if (bitmap != null) {
                this.jDs.put(str, bitmap);
                this.tVf.push(Integer.valueOf(bitmap.hashCode()));
                x.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[]{str, Integer.valueOf(bitmap.hashCode())});
            } else {
                x.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
            }
        }
    }

    public e(a aVar) {
        this.tVc = aVar;
    }

    final void aRU() {
        this.tVd.a(new 3(this));
        this.jDs.a(new f.a<String, Bitmap>() {
        });
    }

    public final void N(int i) {
        int i2 = 0;
        this.if = i;
        if (aRV()) {
            int[] iArr = new int[this.jDr.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.jDr.keyAt(i3);
            }
            while (i2 < iArr.length) {
                int i4 = iArr[i2];
                a(i4, (Bitmap) this.jDr.get(i4));
                i2++;
            }
        }
    }

    public final void O(int i) {
        if (((d) this.tVc).tTx.tTz.adE) {
            if (this.jDz == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 != 0) {
                        if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                            break;
                        }
                        if (i + i2 <= i + 3) {
                            qG(i + i2);
                        }
                        if (i - i2 >= Math.max(i - 3, 0)) {
                            qG(i - i2);
                        }
                    } else {
                        qG(i);
                    }
                    i2++;
                }
            } else if (this.jDz > i) {
                qG(Math.max(i - 3, 0));
            } else if (this.jDz < i) {
                qG(i + 3);
            }
            this.jDz = i;
            d dVar = (d) this.tVc;
            if (dVar != null && dVar.tTx.qC(this.jDz) == null) {
                WxImageView qD = dVar.tTx.qD(this.jDz);
                if (qD != null) {
                    this.tVh = qD.getFullImageBitmap();
                }
            }
        }
    }

    private void qG(int i) {
        if (!this.tVd.bb(Integer.valueOf(i))) {
            au.Em().h(new 5(this, i), 300);
        }
    }

    private boolean aRV() {
        return this.if == 0;
    }

    final void qF(int i) {
        if (this.jDq.get(i) != null) {
            String str = (String) this.jDq.get(i);
            this.jDo.remove(i);
            this.jDq.remove(i);
            this.jDp.remove(str);
            this.jDr.remove(i);
        }
    }

    final void a(int i, View view, String str) {
        this.jDp.put(str, Integer.valueOf(i));
        this.jDq.put(i, str);
        this.jDo.put(i, new WeakReference(view));
    }

    private void a(int i, Bitmap bitmap) {
        if (this.jDo.get(i) != null) {
            View view = (View) ((WeakReference) this.jDo.get(i)).get();
            this.jDq.get(i);
            this.tVc.b(view, bitmap);
            qF(i);
        }
    }

    public final boolean b(ImageView imageView, int i) {
        x.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[]{Integer.valueOf(i)});
        Bitmap bitmap = (Bitmap) this.tVd.get(Integer.valueOf(i));
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        this.tVc.b(imageView, bitmap);
        return true;
    }

    /* renamed from: ahW */
    final void h() {
        if (!this.jDv && this.qD.size() != 0) {
            String str = (String) this.qD.removeLast();
            int intValue = ((Integer) this.tVg.removeLast()).intValue();
            if (this.jDp.containsKey(str)) {
                this.jDv = true;
                this.dMA.c(new 6(this, str, intValue));
            }
        }
    }

    public final void b(int i, Bitmap bitmap) {
        if (i == this.jDz || this.jDz == -1) {
            x.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[]{Integer.valueOf(i)});
            this.tVh = bitmap;
        }
    }

    public final void a(int i, float f, int i2) {
    }
}
