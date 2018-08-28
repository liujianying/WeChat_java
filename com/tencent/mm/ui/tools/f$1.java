package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.ui.tools.f.b;

class f$1 implements AnimatorListener {
    final /* synthetic */ b uzV;
    final /* synthetic */ f uzW;

    f$1(f fVar, b bVar) {
        this.uzW = fVar;
        this.uzV = bVar;
    }

    public final void onAnimationStart(Animator animator) {
        if (this.uzV != null) {
            this.uzV.onAnimationStart();
        }
        this.uzW.nKj = this.uzW.nKg;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.uzV != null) {
            this.uzV.onAnimationEnd();
        }
        this.uzW.nKj = this.uzW.nKh;
    }

    public final void onAnimationCancel(Animator animator) {
        this.uzW.nKj = this.uzW.nKh;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
