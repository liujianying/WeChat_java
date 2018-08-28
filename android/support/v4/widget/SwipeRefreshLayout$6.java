package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$6 extends Animation {
    final /* synthetic */ SwipeRefreshLayout Cm;

    SwipeRefreshLayout$6(SwipeRefreshLayout swipeRefreshLayout) {
        this.Cm = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        int j;
        if (SwipeRefreshLayout.i(this.Cm)) {
            j = (int) SwipeRefreshLayout.j(this.Cm);
        } else {
            j = (int) (SwipeRefreshLayout.j(this.Cm) - ((float) Math.abs(this.Cm.BX)));
        }
        SwipeRefreshLayout.b(this.Cm, (((int) (((float) (j - this.Cm.BV)) * f)) + this.Cm.BV) - SwipeRefreshLayout.e(this.Cm).getTop());
        SwipeRefreshLayout.b(this.Cm).B(1.0f - f);
    }
}
