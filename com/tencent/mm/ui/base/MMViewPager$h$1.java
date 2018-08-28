package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.h;

class MMViewPager$h$1 implements Runnable {
    final /* synthetic */ h tyV;

    MMViewPager$h$1(h hVar) {
        this.tyV = hVar;
    }

    public final void run() {
        MMViewPager.a(this.tyV.tyS).getImageMatrix().getValues(this.tyV.jFk);
        float f = this.tyV.jFk[2];
        float scale = MMViewPager.a(this.tyV.tyS).getScale() * ((float) MMViewPager.a(this.tyV.tyS).getImageWidth());
        if (scale < ((float) MMViewPager.b(this.tyV.tyS))) {
            scale = (((float) MMViewPager.b(this.tyV.tyS)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (MMViewPager.a(this.tyV.tyS) instanceof WxImageView) {
            scale = -((WxImageView) MMViewPager.a(this.tyV.tyS)).getTranslationX();
        }
        if (scale >= 0.0f) {
            this.tyV.bwt = true;
            f = scale;
        } else if (Math.abs(scale) <= 5.0f) {
            this.tyV.bwt = true;
            f = scale;
        } else {
            f = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        MMViewPager.a(this.tyV.tyS).V(f, 0.0f);
        if (MMViewPager.a(this.tyV.tyS) instanceof WxImageView) {
            ((WxImageView) MMViewPager.a(this.tyV.tyS)).translate(f, 0.0f);
        }
    }
}
