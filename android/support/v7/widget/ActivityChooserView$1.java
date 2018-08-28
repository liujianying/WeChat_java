package android.support.v7.widget;

import android.database.DataSetObserver;

class ActivityChooserView$1 extends DataSetObserver {
    final /* synthetic */ ActivityChooserView LK;

    ActivityChooserView$1(ActivityChooserView activityChooserView) {
        this.LK = activityChooserView;
    }

    public final void onChanged() {
        super.onChanged();
        ActivityChooserView.a(this.LK).notifyDataSetChanged();
    }

    public final void onInvalidated() {
        super.onInvalidated();
        ActivityChooserView.a(this.LK).notifyDataSetInvalidated();
    }
}
