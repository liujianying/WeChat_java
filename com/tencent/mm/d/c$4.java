package com.tencent.mm.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class c$4 implements AnimatorListener {
    final /* synthetic */ c bCc;

    c$4(c cVar) {
        this.bCc = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.bCc.bBQ = true;
        c.a(this.bCc, true);
    }

    public final void onAnimationEnd(Animator animator) {
        c.a(this.bCc, true);
    }

    public final void onAnimationCancel(Animator animator) {
        c.a(this.bCc, false);
        animator.removeAllListeners();
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
