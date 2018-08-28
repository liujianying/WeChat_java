package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ShuffleView$6 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$6(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (ShuffleView.z(this.kPn) != null) {
            ShuffleView.z(this.kPn).a(valueAnimator, ShuffleView.w(this.kPn));
        }
    }
}
