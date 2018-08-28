package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.a;

class MMGestureGallery$g extends a {
    float[] jFk = new float[9];
    final /* synthetic */ MMGestureGallery uAo;

    public MMGestureGallery$g(MMGestureGallery mMGestureGallery) {
        this.uAo = mMGestureGallery;
        super(mMGestureGallery);
    }

    public final void play() {
        MMGestureGallery.c(this.uAo).post(new Runnable() {
            public final void run() {
                MMGestureGallery.a(MMGestureGallery$g.this.uAo).getImageMatrix().getValues(MMGestureGallery$g.this.jFk);
                float imageHeight = ((float) MMGestureGallery.a(MMGestureGallery$g.this.uAo).getImageHeight()) * MMGestureGallery.a(MMGestureGallery$g.this.uAo).getScale();
                float f = MMGestureGallery$g.this.jFk[5] + imageHeight;
                float d = (float) MMGestureGallery.d(MMGestureGallery$g.this.uAo);
                if (imageHeight < ((float) MMGestureGallery.d(MMGestureGallery$g.this.uAo))) {
                    d = (((float) MMGestureGallery.d(MMGestureGallery$g.this.uAo)) / 2.0f) + (imageHeight / 2.0f);
                }
                d -= f;
                if (d <= 0.0f) {
                    MMGestureGallery$g.this.bwt = true;
                } else if (Math.abs(d) <= 5.0f) {
                    MMGestureGallery$g.this.bwt = true;
                } else {
                    d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                }
                MMGestureGallery.a(MMGestureGallery$g.this.uAo).V(0.0f, d);
            }
        });
    }
}
