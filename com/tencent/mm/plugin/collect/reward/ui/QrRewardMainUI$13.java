package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$13 implements a {
    final /* synthetic */ QrRewardMainUI hWf;

    QrRewardMainUI$13(QrRewardMainUI qrRewardMainUI) {
        this.hWf = qrRewardMainUI;
    }

    public final void aCb() {
        x.i("MicroMsg.QrRewardMainUI", "click set code, %s", new Object[]{Boolean.valueOf(QrRewardMainUI.c(this.hWf))});
        QrRewardMainUI.a(this.hWf, false);
    }
}
