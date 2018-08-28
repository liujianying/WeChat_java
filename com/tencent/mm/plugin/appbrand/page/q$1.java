package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class q$1 implements AnimatorUpdateListener {
    final /* synthetic */ q goh;

    q$1(q qVar) {
        this.goh = qVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.goh.lq((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
