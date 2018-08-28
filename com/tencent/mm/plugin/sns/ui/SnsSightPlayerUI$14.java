package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;

class SnsSightPlayerUI$14 implements Runnable {
    final /* synthetic */ SnsSightPlayerUI obb;

    SnsSightPlayerUI$14(SnsSightPlayerUI snsSightPlayerUI) {
        this.obb = snsSightPlayerUI;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.obb.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (SnsSightPlayerUI.f(this.obb) instanceof VideoSightView) {
            ((VideoSightView) SnsSightPlayerUI.f(this.obb)).setDrawableWidth(displayMetrics.widthPixels);
        }
        ((View) SnsSightPlayerUI.f(this.obb)).requestLayout();
        ((View) SnsSightPlayerUI.f(this.obb)).postInvalidate();
    }
}
