package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class l$1 implements AnimatorUpdateListener {
    final /* synthetic */ l qHe;

    l$1(l lVar) {
        this.qHe = lVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        l.a(this.qHe, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.qHe.invalidateSelf();
    }
}
