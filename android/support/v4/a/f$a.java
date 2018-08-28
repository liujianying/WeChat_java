package android.support.v4.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class f$a implements AnimatorListener {
    final b ml;
    final g mm;

    public f$a(b bVar, g gVar) {
        this.ml = bVar;
        this.mm = gVar;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.ml.a(this.mm);
    }

    public final void onAnimationCancel(Animator animator) {
        this.ml.bc();
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
