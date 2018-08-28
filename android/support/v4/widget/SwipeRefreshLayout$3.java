package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$3 extends Animation {
    final /* synthetic */ SwipeRefreshLayout Cm;

    SwipeRefreshLayout$3(SwipeRefreshLayout swipeRefreshLayout) {
        this.Cm = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.a(this.Cm, 1.0f - f);
    }
}
