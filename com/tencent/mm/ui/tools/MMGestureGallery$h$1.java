package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.h;

class MMGestureGallery$h$1 implements Runnable {
    final /* synthetic */ h uAq;

    MMGestureGallery$h$1(h hVar) {
        this.uAq = hVar;
    }

    public final void run() {
        float b;
        MMGestureGallery.a(this.uAq.uAo).getImageMatrix().getValues(this.uAq.jFk);
        float scale = MMGestureGallery.a(this.uAq.uAo).getScale() * ((float) MMGestureGallery.a(this.uAq.uAo).getImageWidth());
        float imageHeight = ((float) MMGestureGallery.a(this.uAq.uAo).getImageHeight()) * MMGestureGallery.a(this.uAq.uAo).getScale();
        float f = this.uAq.jFk[2];
        float f2 = this.uAq.jFk[5];
        float f3 = this.uAq.jFk[2] + scale;
        float f4 = this.uAq.jFk[5] + imageHeight;
        float f5 = 0.0f;
        float d = (float) MMGestureGallery.d(this.uAq.uAo);
        float f6 = 0.0f;
        float b2 = (float) MMGestureGallery.b(this.uAq.uAo);
        if (imageHeight < ((float) MMGestureGallery.d(this.uAq.uAo))) {
            f5 = (((float) MMGestureGallery.d(this.uAq.uAo)) / 2.0f) - (imageHeight / 2.0f);
            imageHeight = (((float) MMGestureGallery.d(this.uAq.uAo)) / 2.0f) + (imageHeight / 2.0f);
        } else {
            imageHeight = d;
        }
        d = f5 - f2;
        imageHeight -= f4;
        if (d >= 0.0f) {
            if (imageHeight > 0.0f) {
                d = imageHeight;
            } else {
                d = 0.0f;
            }
        }
        if (scale < ((float) MMGestureGallery.b(this.uAq.uAo))) {
            b = (((float) MMGestureGallery.b(this.uAq.uAo)) / 2.0f) + (scale / 2.0f);
            f6 = (((float) MMGestureGallery.b(this.uAq.uAo)) / 2.0f) - (scale / 2.0f);
        } else {
            b = b2;
        }
        imageHeight = f6 - f;
        b -= f3;
        if (imageHeight >= 0.0f) {
            if (b > 0.0f) {
                imageHeight = b;
            } else {
                imageHeight = 0.0f;
            }
        }
        if (Math.abs(imageHeight) > 5.0f || Math.abs(d) > 5.0f) {
            if (imageHeight >= 0.0f) {
                imageHeight = ((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                imageHeight = (-((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d)))) * 2.0f;
            }
            if (d >= 0.0f) {
                d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                d = (-((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d)))) * 2.0f;
            }
        } else {
            this.uAq.bwt = true;
        }
        MMGestureGallery.a(this.uAq.uAo).V(imageHeight, d);
    }
}
