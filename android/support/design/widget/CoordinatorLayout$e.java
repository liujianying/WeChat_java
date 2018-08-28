package android.support.design.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

class CoordinatorLayout$e implements OnPreDrawListener {
    final /* synthetic */ CoordinatorLayout eN;

    CoordinatorLayout$e(CoordinatorLayout coordinatorLayout) {
        this.eN = coordinatorLayout;
    }

    public final boolean onPreDraw() {
        this.eN.q(false);
        return true;
    }
}
