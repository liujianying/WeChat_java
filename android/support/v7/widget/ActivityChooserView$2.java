package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ActivityChooserView$2 implements OnGlobalLayoutListener {
    final /* synthetic */ ActivityChooserView LK;

    ActivityChooserView$2(ActivityChooserView activityChooserView) {
        this.LK = activityChooserView;
    }

    public final void onGlobalLayout() {
        if (!this.LK.eA()) {
            return;
        }
        if (this.LK.isShown()) {
            ActivityChooserView.b(this.LK).show();
            if (this.LK.LC != null) {
                this.LK.LC.v(true);
                return;
            }
            return;
        }
        ActivityChooserView.b(this.LK).dismiss();
    }
}
