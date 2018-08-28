package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class a$11 implements AnimatorListener {
    final /* synthetic */ a lpk;

    a$11(a aVar) {
        this.lpk = aVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.lpk.lkZ != null) {
            this.lpk.lkZ.requestLayout();
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
