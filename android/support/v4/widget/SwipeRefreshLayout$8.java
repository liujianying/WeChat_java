package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$8 extends Animation {
    final /* synthetic */ SwipeRefreshLayout Cm;

    SwipeRefreshLayout$8(SwipeRefreshLayout swipeRefreshLayout) {
        this.Cm = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.a(this.Cm, SwipeRefreshLayout.k(this.Cm) + ((-SwipeRefreshLayout.k(this.Cm)) * f));
        SwipeRefreshLayout.b(this.Cm, f);
    }
}
