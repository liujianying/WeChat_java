package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class QrRewardGrantUI$7 implements a {
    final /* synthetic */ QrRewardGrantUI hVG;
    final /* synthetic */ e hVH;

    QrRewardGrantUI$7(QrRewardGrantUI qrRewardGrantUI, e eVar) {
        this.hVG = qrRewardGrantUI;
        this.hVH = eVar;
    }

    public final void i(l lVar) {
        QrRewardGrantUI.a(this.hVG, this.hVH.hVb.bQa);
        QrRewardGrantUI.b(this.hVG, this.hVH.hVb.rqr);
        QrRewardGrantUI.c(this.hVG, this.hVH.hVb.rcE);
        QrRewardGrantUI.d(this.hVG, this.hVH.hVb.rqp);
        QrRewardGrantUI.e(this.hVG, this.hVH.hVb.rqo);
        x.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[]{this.hVH.hVb.rqA});
        if (bi.oW(this.hVH.hVb.rqA)) {
            QrRewardGrantUI.d(this.hVG);
        } else {
            h.a(this.hVG.mController.tml, this.hVH.hVb.rqA, "", this.hVG.getString(i.remittance_continue), this.hVG.getString(i.app_cancel), new 1(this), new 2(this));
        }
    }
}
