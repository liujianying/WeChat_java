package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class d {
    private at dMA = new at(1, "album-image-gallery-lazy-loader");
    private int if = 0;
    SparseArray<WeakReference<MultiTouchImageView>> jDo = new SparseArray();
    HashMap<String, Integer> jDp = new HashMap();
    SparseArray<String> jDq = new SparseArray();
    SparseArray<Bitmap> jDr = new SparseArray();
    protected f<String, Bitmap> jDs = new f(5, new 1(this));
    protected SparseIntArray jDt = new SparseIntArray();
    c jDu;
    boolean jDv = false;
    LinkedList<String> qD = new LinkedList();

    public d(c cVar) {
        this.jDu = cVar;
    }

    final void aRU() {
        this.jDs.a(new 2(this));
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

    final boolean aRV() {
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

    private void a(int i, Bitmap bitmap) {
        if (this.jDo.get(i) != null) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) ((WeakReference) this.jDo.get(i)).get();
            String str = (String) this.jDq.get(i);
            if (!(bitmap == null || multiTouchImageView == null)) {
                int hashCode = bitmap.hashCode();
                int indexOfValue = this.jDt.indexOfValue(i);
                if (indexOfValue >= 0) {
                    this.jDt.removeAt(indexOfValue);
                }
                this.jDt.put(hashCode, i);
            }
            this.jDu.jCX.remove(str);
            if (!(bitmap == null || multiTouchImageView == null)) {
                c.a(multiTouchImageView, bitmap);
            }
            qF(i);
        }
    }

    final void ahW() {
        if (!this.jDv && this.qD.size() != 0) {
            String str = (String) this.qD.removeLast();
            if (this.jDp.containsKey(str)) {
                this.jDv = true;
                this.dMA.c(new 3(this, str));
            }
        }
    }
}
