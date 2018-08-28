package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$4 extends Animation {
    final /* synthetic */ SwipeRefreshLayout Cm;
    final /* synthetic */ int Cn;
    final /* synthetic */ int Co;

    SwipeRefreshLayout$4(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.Cm = swipeRefreshLayout;
        this.Cn = i;
        this.Co = i2;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.b(this.Cm).setAlpha((int) (((float) this.Cn) + (((float) (this.Co - this.Cn)) * f)));
    }
}
