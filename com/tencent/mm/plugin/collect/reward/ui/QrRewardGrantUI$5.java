package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.reward.a.a$a;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardGrantUI$5 implements a$a {
    final /* synthetic */ QrRewardGrantUI hVG;

    QrRewardGrantUI$5(QrRewardGrantUI qrRewardGrantUI) {
        this.hVG = qrRewardGrantUI;
    }

    public final void i(l lVar) {
        x.e("MicroMsg.QrRewardGrantUI", "net error: %s", new Object[]{lVar});
    }
}
