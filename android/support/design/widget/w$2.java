package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.u.e.a;

class w$2 extends AnimatorListenerAdapter {
    final /* synthetic */ w ja;
    final /* synthetic */ a jb;

    w$2(w wVar, a aVar) {
        this.ja = wVar;
        this.jb = aVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.jb.onAnimationEnd();
    }

    public final void onAnimationCancel(Animator animator) {
    }
}
