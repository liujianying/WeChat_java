package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class k$2 extends AnimatorListenerAdapter {
    final /* synthetic */ l$a fA = null;
    final /* synthetic */ k fF;
    final /* synthetic */ boolean fz = false;

    k$2(k kVar) {
        this.fF = kVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.fF.fN.i(0, this.fz);
    }

    public final void onAnimationEnd(Animator animator) {
    }
}
