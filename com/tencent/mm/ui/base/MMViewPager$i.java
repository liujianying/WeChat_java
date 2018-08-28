package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMViewPager.a;

class MMViewPager$i extends a {
    float[] jFk = new float[9];
    final /* synthetic */ MMViewPager tyS;

    public MMViewPager$i(MMViewPager mMViewPager) {
        this.tyS = mMViewPager;
        super(mMViewPager);
    }

    public final void play() {
        MMViewPager.c(this.tyS).post(new Runnable() {
            public final void run() {
                MMViewPager.a(MMViewPager$i.this.tyS).getImageMatrix().getValues(MMViewPager$i.this.jFk);
                float imageWidth = ((float) MMViewPager.a(MMViewPager$i.this.tyS).getImageWidth()) * MMViewPager.a(MMViewPager$i.this.tyS).getScale();
                float f = MMViewPager$i.this.jFk[2] + imageWidth;
                float b = (float) MMViewPager.b(MMViewPager$i.this.tyS);
                if (imageWidth < ((float) MMViewPager.b(MMViewPager$i.this.tyS))) {
                    b = (((float) MMViewPager.b(MMViewPager$i.this.tyS)) / 2.0f) + (imageWidth / 2.0f);
                }
                b -= f;
                if (MMViewPager.a(MMViewPager$i.this.tyS) instanceof WxImageView) {
                    b = -((WxImageView) MMViewPager.a(MMViewPager$i.this.tyS)).getTranslationX();
                }
                if (b <= 0.0f) {
                    MMViewPager$i.this.bwt = true;
                    imageWidth = b;
                } else if (Math.abs(b) <= 5.0f) {
                    MMViewPager$i.this.bwt = true;
                    imageWidth = b;
                } else {
                    imageWidth = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
                }
                MMViewPager.a(MMViewPager$i.this.tyS).V(imageWidth, 0.0f);
                if (MMViewPager.a(MMViewPager$i.this.tyS) instanceof WxImageView) {
                    ((WxImageView) MMViewPager.a(MMViewPager$i.this.tyS)).translate(imageWidth, 0.0f);
                }
            }
        });
    }
}
