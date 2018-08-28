package com.tencent.mm.plugin.appbrand.game.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class b$3 implements AnimatorUpdateListener {
    final /* synthetic */ b fBh;
    int height = b.agr();

    b$3(b bVar) {
        this.fBh = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.fBh.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.height));
        this.fBh.requestLayout();
    }
}
