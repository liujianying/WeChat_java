package android.support.design.widget;

import android.support.v4.view.z;
import android.view.View;

class BottomSheetBehavior$b implements Runnable {
    final /* synthetic */ BottomSheetBehavior cJ;
    private final int cK;
    private final View mView;

    public BottomSheetBehavior$b(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.cJ = bottomSheetBehavior;
        this.mView = view;
        this.cK = i;
    }

    public final void run() {
        if (BottomSheetBehavior.j(this.cJ) == null || !BottomSheetBehavior.j(this.cJ).cX()) {
            BottomSheetBehavior.b(this.cJ, this.cK);
        } else {
            z.a(this.mView, this);
        }
    }
}
