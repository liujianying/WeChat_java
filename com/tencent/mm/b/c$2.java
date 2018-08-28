package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements AnimatorListener {
    final /* synthetic */ c bwA;

    public c$2(c cVar) {
        this.bwA = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.bwA.bwt = false;
        this.bwA.bwy = 0.0f;
        this.bwA.bwz = 0.0f;
        x.d("MicroMsg.StickBackAnim", "onAnimationStart");
    }

    public final void onAnimationEnd(Animator animator) {
        this.bwA.bwt = true;
        this.bwA.bwy = 0.0f;
        this.bwA.bwz = 0.0f;
    }

    public final void onAnimationCancel(Animator animator) {
        this.bwA.bwt = true;
        this.bwA.bwy = 0.0f;
        this.bwA.bwz = 0.0f;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
