package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.u;

class QrRewardGrantUI$2 extends u {
    final /* synthetic */ QrRewardGrantUI hVG;

    QrRewardGrantUI$2(QrRewardGrantUI qrRewardGrantUI) {
        this.hVG = qrRewardGrantUI;
    }

    public final void aBU() {
        if (QrRewardGrantUI.a(this.hVG, (int) Math.round(bi.getDouble(QrRewardGrantUI.a(this.hVG).getText(), 0.0d) * 100.0d))) {
            QrRewardGrantUI.b(this.hVG);
        }
    }
}
