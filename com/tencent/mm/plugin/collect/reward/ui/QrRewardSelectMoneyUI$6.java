package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.aa.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class QrRewardSelectMoneyUI$6 implements a {
    final /* synthetic */ QrRewardSelectMoneyUI hWw;
    final /* synthetic */ long hWz;

    QrRewardSelectMoneyUI$6(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, long j) {
        this.hWw = qrRewardSelectMoneyUI;
        this.hWz = j;
    }

    public final void x(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (bi.VF() - this.hWz) + " ms");
            c.J(str, 3);
            q.KJ().jO(str);
        } else {
            x.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
        }
        b.a(QrRewardSelectMoneyUI.c(this.hWw), str, 0.03f, false);
        QrRewardSelectMoneyUI.d(this.hWw).setText(j.a(this.hWw.mController.tml, e.gT(str)));
    }
}
