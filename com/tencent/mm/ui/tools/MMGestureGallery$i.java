package com.tencent.mm.ui.tools;

class MMGestureGallery$i extends MMGestureGallery$a {
    float[] jFk = new float[9];
    final /* synthetic */ MMGestureGallery uAo;

    public MMGestureGallery$i(MMGestureGallery mMGestureGallery) {
        this.uAo = mMGestureGallery;
        super(mMGestureGallery);
    }

    public final void play() {
        MMGestureGallery.c(this.uAo).post(new 1(this));
    }
}
