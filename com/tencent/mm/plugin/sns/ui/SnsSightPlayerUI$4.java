package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.tools.f.b;

class SnsSightPlayerUI$4 implements b {
    final /* synthetic */ SnsSightPlayerUI obb;

    SnsSightPlayerUI$4(SnsSightPlayerUI snsSightPlayerUI) {
        this.obb = snsSightPlayerUI;
    }

    public final void onAnimationStart() {
        if (SnsSightPlayerUI.p(this.obb) != null) {
            SnsSightPlayerUI.p(this.obb).setVisibility(8);
        }
    }

    public final void onAnimationEnd() {
        new ag().post(new 1(this));
    }
}
