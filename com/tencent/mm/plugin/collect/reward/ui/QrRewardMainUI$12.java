package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$12 implements a {
    final /* synthetic */ QrRewardMainUI hWf;

    QrRewardMainUI$12(QrRewardMainUI qrRewardMainUI) {
        this.hWf = qrRewardMainUI;
    }

    public final void aCb() {
        x.i("MicroMsg.QrRewardMainUI", "click save code");
        QrRewardMainUI.b(this.hWf);
        h.mEJ.h(14721, Integer.valueOf(1), Integer.valueOf(5));
    }
}
