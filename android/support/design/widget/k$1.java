package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.l.a;

class k$1 extends AnimatorListenerAdapter {
    final /* synthetic */ a fA = null;
    private boolean fE;
    final /* synthetic */ k fF;
    final /* synthetic */ boolean fz = false;

    k$1(k kVar) {
        this.fF = kVar;
    }

    public final void onAnimationStart(Animator animator) {
        k.a(this.fF, true);
        this.fE = false;
        this.fF.fN.i(0, this.fz);
    }

    public final void onAnimationCancel(Animator animator) {
        k.a(this.fF, false);
        this.fE = true;
    }

    public final void onAnimationEnd(Animator animator) {
        k.a(this.fF, false);
        if (!this.fE) {
            this.fF.fN.i(8, this.fz);
        }
    }
}
