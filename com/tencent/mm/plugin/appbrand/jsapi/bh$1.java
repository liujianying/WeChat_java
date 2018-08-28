package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.appbrand.page.p;

class bh$1 implements AnimatorUpdateListener {
    final /* synthetic */ p fGY;
    final /* synthetic */ bh fHf;

    bh$1(bh bhVar, p pVar) {
        this.fHf = bhVar;
        this.fGY = pVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.fGY.kr(((Integer) valueAnimator.getAnimatedValue()).intValue());
        this.fGY.kp(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
