package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.j;

class MMViewPager$j$1 implements Runnable {
    final /* synthetic */ j tyX;

    MMViewPager$j$1(j jVar) {
        this.tyX = jVar;
    }

    public final void run() {
        MMViewPager.a(this.tyX.tyS).getImageMatrix().getValues(this.tyX.jFk);
        float f = this.tyX.jFk[5];
        float scale = MMViewPager.a(this.tyX.tyS).getScale() * ((float) MMViewPager.a(this.tyX.tyS).getImageHeight());
        if (scale < ((float) MMViewPager.d(this.tyX.tyS))) {
            scale = (((float) MMViewPager.d(this.tyX.tyS)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (MMViewPager.a(this.tyX.tyS) instanceof WxImageView) {
            scale = -((WxImageView) MMViewPager.a(this.tyX.tyS)).getTranslationY();
        }
        if (scale >= 0.0f) {
            this.tyX.bwt = true;
            f = scale;
        } else if (Math.abs(scale) <= 5.0f) {
            this.tyX.bwt = true;
            f = scale;
        } else {
            f = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        MMViewPager.a(this.tyX.tyS).V(0.0f, f);
        if (MMViewPager.a(this.tyX.tyS) instanceof WxImageView) {
            ((WxImageView) MMViewPager.a(this.tyX.tyS)).translate(0.0f, f);
        }
    }
}
