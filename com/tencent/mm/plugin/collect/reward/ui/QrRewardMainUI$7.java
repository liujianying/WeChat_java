package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class QrRewardMainUI$7 implements a {
    final /* synthetic */ QrRewardMainUI hWf;

    QrRewardMainUI$7(QrRewardMainUI qrRewardMainUI) {
        this.hWf = qrRewardMainUI;
    }

    public final void aCb() {
        x.d("MicroMsg.QrRewardMainUI", "go to: %s", new Object[]{QrRewardMainUI.q(this.hWf)});
        e.l(this.hWf.mController.tml, QrRewardMainUI.q(this.hWf), false);
        h.mEJ.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(6)});
    }
}
