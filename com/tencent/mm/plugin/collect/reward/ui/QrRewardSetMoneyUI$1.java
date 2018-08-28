package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.u;

class QrRewardSetMoneyUI$1 extends u {
    final /* synthetic */ QrRewardSetMoneyUI hWL;

    QrRewardSetMoneyUI$1(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        this.hWL = qrRewardSetMoneyUI;
    }

    public final void aBU() {
        if (QrRewardSetMoneyUI.a(this.hWL)) {
            x.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
        } else {
            QrRewardSetMoneyUI.b(this.hWL);
        }
        h.mEJ.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
    }
}
