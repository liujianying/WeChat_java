package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.j;

class MMGestureGallery$j$1 implements Runnable {
    final /* synthetic */ j uAs;

    MMGestureGallery$j$1(j jVar) {
        this.uAs = jVar;
    }

    public final void run() {
        MMGestureGallery.a(this.uAs.uAo).getImageMatrix().getValues(this.uAs.jFk);
        float imageWidth = ((float) MMGestureGallery.a(this.uAs.uAo).getImageWidth()) * MMGestureGallery.a(this.uAs.uAo).getScale();
        float f = this.uAs.jFk[2] + imageWidth;
        float b = (float) MMGestureGallery.b(this.uAs.uAo);
        if (imageWidth < ((float) MMGestureGallery.b(this.uAs.uAo))) {
            b = (((float) MMGestureGallery.b(this.uAs.uAo)) / 2.0f) + (imageWidth / 2.0f);
        }
        b -= f;
        if (b <= 0.0f) {
            this.uAs.bwt = true;
        } else if (Math.abs(b) <= 5.0f) {
            this.uAs.bwt = true;
        } else {
            b = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
        }
        MMGestureGallery.a(this.uAs.uAo).V(b, 0.0f);
    }
}
