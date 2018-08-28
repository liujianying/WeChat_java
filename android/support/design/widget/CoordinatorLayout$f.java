package android.support.design.widget;

import android.support.v4.view.z;
import android.view.View;
import java.util.Comparator;

class CoordinatorLayout$f implements Comparator<View> {
    CoordinatorLayout$f() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        View view = (View) obj2;
        float aj = z.aj((View) obj);
        float aj2 = z.aj(view);
        if (aj > aj2) {
            return -1;
        }
        return aj < aj2 ? 1 : 0;
    }
}
