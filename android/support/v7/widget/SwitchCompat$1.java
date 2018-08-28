package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwitchCompat$1 implements AnimationListener {
    final /* synthetic */ boolean Wi;
    final /* synthetic */ SwitchCompat Wj;

    SwitchCompat$1(SwitchCompat switchCompat, boolean z) {
        this.Wj = switchCompat;
        this.Wi = z;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (SwitchCompat.a(this.Wj) == animation) {
            SwitchCompat.a(this.Wj, this.Wi ? 1.0f : 0.0f);
            SwitchCompat.b(this.Wj);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
