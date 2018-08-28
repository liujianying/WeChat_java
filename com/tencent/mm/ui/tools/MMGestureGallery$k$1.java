package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.k;

class MMGestureGallery$k$1 implements Runnable {
    final /* synthetic */ k uAt;

    MMGestureGallery$k$1(k kVar) {
        this.uAt = kVar;
    }

    public final void run() {
        MMGestureGallery.a(this.uAt.uAo).getImageMatrix().getValues(this.uAt.jFk);
        float f = this.uAt.jFk[5];
        float scale = MMGestureGallery.a(this.uAt.uAo).getScale() * ((float) MMGestureGallery.a(this.uAt.uAo).getImageHeight());
        if (scale < ((float) MMGestureGallery.d(this.uAt.uAo))) {
            scale = (((float) MMGestureGallery.d(this.uAt.uAo)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.uAt.bwt = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.uAt.bwt = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        MMGestureGallery.a(this.uAt.uAo).V(0.0f, scale);
    }
}
