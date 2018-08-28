package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ShuffleView$7 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$7(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (ShuffleView.A(this.kPn) != null) {
            ShuffleView.A(this.kPn).a(valueAnimator, ShuffleView.u(this.kPn));
        }
    }
}
