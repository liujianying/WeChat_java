package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.d;
import android.view.View;
import java.util.Comparator;

class CoordinatorLayout$1 implements Comparator<View> {
    final /* synthetic */ CoordinatorLayout eN;

    CoordinatorLayout$1(CoordinatorLayout coordinatorLayout) {
        this.eN = coordinatorLayout;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        View view = (View) obj;
        View view2 = (View) obj2;
        if (view != view2) {
            if (((d) view.getLayoutParams()).n(view2)) {
                return 1;
            }
            if (((d) view2.getLayoutParams()).n(view)) {
                return -1;
            }
        }
        return 0;
    }
}
