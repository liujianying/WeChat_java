package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.g;

class MMViewPager$g$1 implements Runnable {
    final /* synthetic */ g tyU;

    MMViewPager$g$1(g gVar) {
        this.tyU = gVar;
    }

    public final void run() {
        float b;
        MMViewPager.a(this.tyU.tyS).getImageMatrix().getValues(this.tyU.jFk);
        float scale = MMViewPager.a(this.tyU.tyS).getScale() * ((float) MMViewPager.a(this.tyU.tyS).getImageWidth());
        float imageHeight = ((float) MMViewPager.a(this.tyU.tyS).getImageHeight()) * MMViewPager.a(this.tyU.tyS).getScale();
        float f = this.tyU.jFk[2];
        float f2 = this.tyU.jFk[5];
        float f3 = this.tyU.jFk[2] + scale;
        float f4 = this.tyU.jFk[5] + imageHeight;
        float f5 = 0.0f;
        float d = (float) MMViewPager.d(this.tyU.tyS);
        float f6 = 0.0f;
        float b2 = (float) MMViewPager.b(this.tyU.tyS);
        if (imageHeight < ((float) MMViewPager.d(this.tyU.tyS))) {
            f5 = (((float) MMViewPager.d(this.tyU.tyS)) / 2.0f) - (imageHeight / 2.0f);
            imageHeight = (((float) MMViewPager.d(this.tyU.tyS)) / 2.0f) + (imageHeight / 2.0f);
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
        if (scale < ((float) MMViewPager.b(this.tyU.tyS))) {
            b = (((float) MMViewPager.b(this.tyU.tyS)) / 2.0f) + (scale / 2.0f);
            f6 = (((float) MMViewPager.b(this.tyU.tyS)) / 2.0f) - (scale / 2.0f);
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
        if (MMViewPager.a(this.tyU.tyS) instanceof WxImageView) {
            imageHeight = ((WxImageView) MMViewPager.a(this.tyU.tyS)).getTranslationX();
            d = ((WxImageView) MMViewPager.a(this.tyU.tyS)).getTranslationY();
        }
        if (Math.abs(imageHeight) > 5.0f || Math.abs(d) > 5.0f) {
            if (imageHeight >= 0.0f) {
                imageHeight = ((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                imageHeight = (-((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d)))) * 2.0f;
            }
            if (d >= 0.0f) {
                b = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                b = (-((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d)))) * 2.0f;
            }
        } else {
            this.tyU.bwt = true;
            b = d;
        }
        MMViewPager.a(this.tyU.tyS).V(imageHeight, b);
        if (MMViewPager.a(this.tyU.tyS) instanceof WxImageView) {
            ((WxImageView) MMViewPager.a(this.tyU.tyS)).translate(-imageHeight, -b);
        }
    }
}
