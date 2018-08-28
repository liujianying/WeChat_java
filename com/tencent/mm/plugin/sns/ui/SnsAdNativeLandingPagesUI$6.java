package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.snackbar.a.b;

class SnsAdNativeLandingPagesUI$6 implements b {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$6(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void aMj() {
        try {
            AdLandingPagesProxy.getInstance().favEditTag();
        } catch (Exception e) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + e.getMessage());
        }
    }
}
