package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class g$2 implements AnimatorUpdateListener {
    final /* synthetic */ g gGd;

    g$2(g gVar) {
        this.gGd = gVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.gGd.view != null) {
            this.gGd.view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }
}
