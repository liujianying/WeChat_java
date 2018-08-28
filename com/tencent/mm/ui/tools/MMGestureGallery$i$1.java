package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.i;

class MMGestureGallery$i$1 implements Runnable {
    final /* synthetic */ i uAr;

    MMGestureGallery$i$1(i iVar) {
        this.uAr = iVar;
    }

    public final void run() {
        MMGestureGallery.a(this.uAr.uAo).getImageMatrix().getValues(this.uAr.jFk);
        float f = this.uAr.jFk[2];
        float scale = MMGestureGallery.a(this.uAr.uAo).getScale() * ((float) MMGestureGallery.a(this.uAr.uAo).getImageWidth());
        if (scale < ((float) MMGestureGallery.b(this.uAr.uAo))) {
            scale = (((float) MMGestureGallery.b(this.uAr.uAo)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.uAr.bwt = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.uAr.bwt = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        MMGestureGallery.a(this.uAr.uAo).V(scale, 0.0f);
    }
}
