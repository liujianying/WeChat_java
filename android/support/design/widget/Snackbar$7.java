package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Snackbar$7 implements AnimationListener {
    final /* synthetic */ Snackbar gF;

    Snackbar$7(Snackbar snackbar) {
        this.gF = snackbar;
    }

    public final void onAnimationEnd(Animation animation) {
        Snackbar.g(this.gF);
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
