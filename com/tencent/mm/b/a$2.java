package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class a$2 implements AnimatorListener {
    final /* synthetic */ a bws;

    a$2(a aVar) {
        this.bws = aVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.bws.bwh.bBQ = true;
        this.bws.bwt = false;
        this.bws.bwu = true;
    }

    public final void onAnimationEnd(Animator animator) {
        this.bws.bwt = true;
        this.bws.bwu = false;
        this.bws.bwo = 0;
        this.bws.bwh.vR();
        this.bws.bwh.vP();
        if (this.bws.bwp != null) {
            this.bws.bwp.onAnimationEnd(animator);
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
