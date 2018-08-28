package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.a;

class MMGestureGallery$j extends a {
    float[] jFk = new float[9];
    final /* synthetic */ MMGestureGallery uAo;

    public MMGestureGallery$j(MMGestureGallery mMGestureGallery) {
        this.uAo = mMGestureGallery;
        super(mMGestureGallery);
    }

    public final void play() {
        MMGestureGallery.c(this.uAo).post(new 1(this));
    }
}
