package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class QrRewardMainUI$3 implements a {
    final /* synthetic */ QrRewardMainUI hWf;
    final /* synthetic */ h hWg;

    QrRewardMainUI$3(QrRewardMainUI qrRewardMainUI, h hVar) {
        this.hWf = qrRewardMainUI;
        this.hWg = hVar;
    }

    public final void i(l lVar) {
        x.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", new Object[]{this.hWg.hqp, QrRewardMainUI.l(this.hWf).getText()});
        if (this.hWg.hqp.equals(QrRewardMainUI.m(this.hWf))) {
            g.Ei().DT().a(aa.a.sYP, QrRewardMainUI.m(this.hWf));
            QrRewardMainUI.i(this.hWf);
        }
    }
}
