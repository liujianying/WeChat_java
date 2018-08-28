package com.tencent.mm.plugin.sns.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;

class SnsSightPlayerUI$3 implements OnPreDrawListener {
    final /* synthetic */ SnsSightPlayerUI obb;

    SnsSightPlayerUI$3(SnsSightPlayerUI snsSightPlayerUI) {
        this.obb = snsSightPlayerUI;
    }

    public final boolean onPreDraw() {
        this.obb.ndZ.getViewTreeObserver().removeOnPreDrawListener(this);
        this.obb.hDi.a(this.obb.ndZ, SnsSightPlayerUI.s(this.obb), null);
        return true;
    }
}
