package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.smtt.sdk.WebView;

class SwipeRefreshLayout$1 implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout Cm;

    SwipeRefreshLayout$1(SwipeRefreshLayout swipeRefreshLayout) {
        this.Cm = swipeRefreshLayout;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (SwipeRefreshLayout.a(this.Cm)) {
            SwipeRefreshLayout.b(this.Cm).setAlpha(WebView.NORMAL_MODE_ALPHA);
            SwipeRefreshLayout.b(this.Cm).start();
            if (SwipeRefreshLayout.c(this.Cm) && SwipeRefreshLayout.d(this.Cm) != null) {
                SwipeRefreshLayout.d(this.Cm);
            }
            SwipeRefreshLayout.a(this.Cm, SwipeRefreshLayout.e(this.Cm).getTop());
            return;
        }
        SwipeRefreshLayout.f(this.Cm);
    }
}
