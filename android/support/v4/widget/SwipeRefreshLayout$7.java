package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$7 extends Animation {
    final /* synthetic */ SwipeRefreshLayout Cm;

    SwipeRefreshLayout$7(SwipeRefreshLayout swipeRefreshLayout) {
        this.Cm = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.b(this.Cm, f);
    }
}
