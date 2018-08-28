package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ShuffleView$4 implements AnimatorListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$4(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final void onAnimationStart(Animator animator) {
        ShuffleView.a(this.kPn, true);
    }

    public final void onAnimationEnd(Animator animator) {
        ShuffleView.a(this.kPn, false);
        ShuffleView.u(this.kPn).setVisibility(0);
        if (ShuffleView.v(this.kPn) != null) {
            ShuffleView.v(this.kPn).start();
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
