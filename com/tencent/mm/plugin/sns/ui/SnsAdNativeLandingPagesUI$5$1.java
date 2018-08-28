package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.5;
import com.tencent.mm.sdk.platformtools.ag;

class SnsAdNativeLandingPagesUI$5$1 implements b$b {
    final /* synthetic */ 5 nSS;

    SnsAdNativeLandingPagesUI$5$1(5 5) {
        this.nSS = 5;
    }

    public final void onAnimationStart() {
        SnsAdNativeLandingPagesUI.J(this.nSS.nSR).setVisibility(8);
    }

    public final void onAnimationEnd() {
        new ag().post(new 1(this));
    }
}
