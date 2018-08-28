package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.14;
import com.tencent.mm.sdk.platformtools.ah;

class SnsAdNativeLandingPagesUI$14$1 implements Runnable {
    final /* synthetic */ Object fEv;
    final /* synthetic */ 14 nSY;

    SnsAdNativeLandingPagesUI$14$1(14 14, Object obj) {
        this.nSY = 14;
        this.fEv = obj;
    }

    public final void run() {
        this.nSY.nSR.nRW = e.d(SnsAdNativeLandingPagesUI.j(this.nSY.nSR), SnsAdNativeLandingPagesUI.k(this.nSY.nSR), (String) this.fEv, SnsAdNativeLandingPagesUI.l(this.nSY.nSR), SnsAdNativeLandingPagesUI.m(this.nSY.nSR));
        ah.A(new 1(this));
    }
}
