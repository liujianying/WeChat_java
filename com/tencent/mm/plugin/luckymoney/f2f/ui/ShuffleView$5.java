package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class ShuffleView$5 implements AnimatorListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$5(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        ShuffleView.e(this.kPn).remove(ShuffleView.w(this.kPn));
        if (ShuffleView.x(this.kPn) != null) {
            ShuffleView.x(this.kPn).start();
        }
        ShuffleView.f(this.kPn, ShuffleView.f(this.kPn));
        if (ShuffleView.d(this.kPn) > 0) {
            ShuffleView.e(this.kPn, ShuffleView.y(this.kPn));
            ShuffleView.b(this.kPn, (View) ShuffleView.e(this.kPn).get(ShuffleView.f(this.kPn)));
            return;
        }
        ShuffleView.b(this.kPn, null);
        ShuffleView.e(this.kPn, 0);
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
