package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.a;

class MMGestureGallery$k extends a {
    float[] jFk = new float[9];
    final /* synthetic */ MMGestureGallery uAo;

    public MMGestureGallery$k(MMGestureGallery mMGestureGallery) {
        this.uAo = mMGestureGallery;
        super(mMGestureGallery);
    }

    public final void play() {
        MMGestureGallery.c(this.uAo).post(new 1(this));
    }
}
