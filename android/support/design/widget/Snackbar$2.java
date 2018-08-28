package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Snackbar$2 implements AnimationListener {
    final /* synthetic */ Snackbar gF;
    final /* synthetic */ int val$event;

    Snackbar$2(Snackbar snackbar, int i) {
        this.gF = snackbar;
        this.val$event = i;
    }

    public final void onAnimationEnd(Animation animation) {
        Snackbar.c(this.gF);
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
