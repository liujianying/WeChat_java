package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.appbrand.page.p;

class bh$3 implements AnimatorUpdateListener {
    final /* synthetic */ p fGY;
    final /* synthetic */ bh fHf;

    bh$3(bh bhVar, p pVar) {
        this.fHf = bhVar;
        this.fGY = pVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.fGY.q((double) ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
