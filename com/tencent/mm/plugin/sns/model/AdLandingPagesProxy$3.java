package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.b.b;

class AdLandingPagesProxy$3 implements b {
    final /* synthetic */ AdLandingPagesProxy nmu;

    AdLandingPagesProxy$3(AdLandingPagesProxy adLandingPagesProxy) {
        this.nmu = adLandingPagesProxy;
    }

    public final void LR(String str) {
    }

    public final void bxb() {
    }

    public final void aT(String str, boolean z) {
    }

    public final void aS(String str, boolean z) {
        this.nmu.CLIENT_CALL("onImgDownloadCallback", new Object[]{str, Boolean.valueOf(z)});
    }
}
