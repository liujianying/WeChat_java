package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$5 implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout Cm;

    SwipeRefreshLayout$5(SwipeRefreshLayout swipeRefreshLayout) {
        this.Cm = swipeRefreshLayout;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (!SwipeRefreshLayout.g(this.Cm)) {
            SwipeRefreshLayout.h(this.Cm);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
