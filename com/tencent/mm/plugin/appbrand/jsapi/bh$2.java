package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.appbrand.page.p;

class bh$2 implements AnimatorUpdateListener {
    final /* synthetic */ p fGY;
    final /* synthetic */ bh fHf;

    bh$2(bh bhVar, p pVar) {
        this.fHf = bhVar;
        this.fGY = pVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.fGY.kq(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
