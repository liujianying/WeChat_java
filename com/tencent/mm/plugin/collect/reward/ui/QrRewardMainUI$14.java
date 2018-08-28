package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$14 implements a {
    final /* synthetic */ QrRewardMainUI hWf;
    final /* synthetic */ b hWk;

    QrRewardMainUI$14(QrRewardMainUI qrRewardMainUI, b bVar) {
        this.hWf = qrRewardMainUI;
        this.hWk = bVar;
    }

    public final void i(l lVar) {
        x.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[]{lVar});
        if (!this.hWk.hUY) {
            QrRewardMainUI.a(this.hWf, false);
        }
    }
}
