package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ShuffleView$2 implements AnimatorListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$2(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final void onAnimationStart(Animator animator) {
        ShuffleView.a(this.kPn, true);
    }

    public final void onAnimationEnd(Animator animator) {
        ShuffleView.a(this.kPn, false);
        ShuffleView.a(this.kPn, null);
        ShuffleView.d(this.kPn, -1);
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
