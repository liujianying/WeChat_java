package android.support.design.widget;

import android.support.design.widget.BottomSheetBehavior.b;
import android.support.v4.view.z;
import android.support.v4.widget.u.a;
import android.view.View;

class BottomSheetBehavior$1 extends a {
    final /* synthetic */ BottomSheetBehavior cJ;

    BottomSheetBehavior$1(BottomSheetBehavior bottomSheetBehavior) {
        this.cJ = bottomSheetBehavior;
    }

    public final boolean b(View view, int i) {
        if (BottomSheetBehavior.a(this.cJ) == 1) {
            return false;
        }
        if (BottomSheetBehavior.b(this.cJ)) {
            return false;
        }
        if (BottomSheetBehavior.a(this.cJ) == 3 && BottomSheetBehavior.c(this.cJ) == i) {
            View view2 = (View) BottomSheetBehavior.d(this.cJ).get();
            if (view2 != null && z.h(view2, -1)) {
                return false;
            }
        }
        return BottomSheetBehavior.e(this.cJ) != null && BottomSheetBehavior.e(this.cJ).get() == view;
    }

    public final void a(View view, int i, int i2) {
        BottomSheetBehavior.a(this.cJ, i2);
    }

    public final void t(int i) {
        if (i == 1) {
            BottomSheetBehavior.b(this.cJ, 1);
        }
    }

    public final void a(View view, float f, float f2) {
        int f3;
        int i = 3;
        if (f2 < 0.0f) {
            f3 = BottomSheetBehavior.f(this.cJ);
        } else if (BottomSheetBehavior.g(this.cJ) && BottomSheetBehavior.a(this.cJ, view, f2)) {
            i = 5;
            f3 = BottomSheetBehavior.h(this.cJ);
        } else if (f2 == 0.0f) {
            f3 = view.getTop();
            if (Math.abs(f3 - BottomSheetBehavior.f(this.cJ)) < Math.abs(f3 - BottomSheetBehavior.i(this.cJ))) {
                f3 = BottomSheetBehavior.f(this.cJ);
            } else {
                f3 = BottomSheetBehavior.i(this.cJ);
                i = 4;
            }
        } else {
            f3 = BottomSheetBehavior.i(this.cJ);
            i = 4;
        }
        if (BottomSheetBehavior.j(this.cJ).w(view.getLeft(), f3)) {
            BottomSheetBehavior.b(this.cJ, 2);
            z.a(view, new b(this.cJ, view, i));
            return;
        }
        BottomSheetBehavior.b(this.cJ, i);
    }

    public final int c(View view, int i) {
        return n.e(i, BottomSheetBehavior.f(this.cJ), BottomSheetBehavior.g(this.cJ) ? BottomSheetBehavior.h(this.cJ) : BottomSheetBehavior.i(this.cJ));
    }

    public final int d(View view, int i) {
        return view.getLeft();
    }

    public final int V() {
        if (BottomSheetBehavior.g(this.cJ)) {
            return BottomSheetBehavior.h(this.cJ) - BottomSheetBehavior.f(this.cJ);
        }
        return BottomSheetBehavior.i(this.cJ) - BottomSheetBehavior.f(this.cJ);
    }
}
