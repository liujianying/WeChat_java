package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class d$2 implements AnimatorUpdateListener {
    final /* synthetic */ d gMy;

    d$2(d dVar) {
        this.gMy = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.gMy.gMr.setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
    }
}
