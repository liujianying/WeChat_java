package android.support.v7.widget;

import android.database.DataSetObserver;

class ActivityChooserView$4 extends DataSetObserver {
    final /* synthetic */ ActivityChooserView LK;

    ActivityChooserView$4(ActivityChooserView activityChooserView) {
        this.LK = activityChooserView;
    }

    public final void onChanged() {
        super.onChanged();
        ActivityChooserView.c(this.LK);
    }
}
