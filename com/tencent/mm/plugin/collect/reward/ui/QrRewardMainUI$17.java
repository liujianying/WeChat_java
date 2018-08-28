package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class QrRewardMainUI$17 implements a {
    final /* synthetic */ QrRewardMainUI hWf;

    QrRewardMainUI$17(QrRewardMainUI qrRewardMainUI) {
        this.hWf = qrRewardMainUI;
    }

    public final void i(l lVar) {
        x.e("MicroMsg.QrRewardMainUI", "net error: %s", new Object[]{lVar});
        QrRewardMainUI.a(this.hWf, (String) g.Ei().DT().get(aa.a.sYP, ""));
        QrRewardMainUI.c(this.hWf, QrRewardMainUI.k(this.hWf));
        QrRewardMainUI.l(this.hWf).setText("");
        QrRewardMainUI.i(this.hWf);
    }
}
