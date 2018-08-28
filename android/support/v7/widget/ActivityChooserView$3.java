package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow.b;
import android.view.View;

class ActivityChooserView$3 extends b {
    final /* synthetic */ ActivityChooserView LK;

    ActivityChooserView$3(ActivityChooserView activityChooserView, View view) {
        this.LK = activityChooserView;
        super(view);
    }

    public final ListPopupWindow dB() {
        return ActivityChooserView.b(this.LK);
    }

    protected final boolean dC() {
        this.LK.ey();
        return true;
    }

    protected final boolean em() {
        this.LK.ez();
        return true;
    }
}
