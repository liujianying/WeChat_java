package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;

class SnsAdNativeLandingPagesUI$4 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$4(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void run() {
        SnsAdNativeLandingPagesUI.n(this.nSR);
        this.nSR.setRequestedOrientation(1);
        SnsAdNativeLandingPagesUI.bCS();
        ((b) SnsAdNativeLandingPagesUI.h(this.nSR).get(Integer.valueOf(((c) this.nSR.nRW.getFirst()).id))).bAw();
        SnsAdNativeLandingPagesUI.M(this.nSR);
    }
}
