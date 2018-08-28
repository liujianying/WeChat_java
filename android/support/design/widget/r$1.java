package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class r$1 implements AnimationListener {
    final /* synthetic */ r gV;

    r$1(r rVar) {
        this.gV = rVar;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.gV.gT == animation) {
            this.gV.gT = null;
        }
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
