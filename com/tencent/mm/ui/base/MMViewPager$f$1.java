package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.f;

class MMViewPager$f$1 implements Runnable {
    final /* synthetic */ f tyT;

    MMViewPager$f$1(f fVar) {
        this.tyT = fVar;
    }

    public final void run() {
        MMViewPager.a(this.tyT.tyS).getImageMatrix().getValues(this.tyT.jFk);
        float imageHeight = ((float) MMViewPager.a(this.tyT.tyS).getImageHeight()) * MMViewPager.a(this.tyT.tyS).getScale();
        float f = this.tyT.jFk[5] + imageHeight;
        float d = (float) MMViewPager.d(this.tyT.tyS);
        if (imageHeight < ((float) MMViewPager.d(this.tyT.tyS))) {
            d = (((float) MMViewPager.d(this.tyT.tyS)) / 2.0f) + (imageHeight / 2.0f);
        }
        d -= f;
        if (MMViewPager.a(this.tyT.tyS) instanceof WxImageView) {
            d = -((WxImageView) MMViewPager.a(this.tyT.tyS)).getTranslationY();
        }
        if (d <= 0.0f) {
            this.tyT.bwt = true;
            imageHeight = d;
        } else if (Math.abs(d) <= 5.0f) {
            this.tyT.bwt = true;
            imageHeight = d;
        } else {
            imageHeight = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
        }
        MMViewPager.a(this.tyT.tyS).V(0.0f, imageHeight);
        if (MMViewPager.a(this.tyT.tyS) instanceof WxImageView) {
            ((WxImageView) MMViewPager.a(this.tyT.tyS)).translate(0.0f, imageHeight);
        }
    }
}
