package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class HoneyPayReceiveCardUI$9 implements a {
    final /* synthetic */ HoneyPayReceiveCardUI kmc;
    final /* synthetic */ bdk kme;

    HoneyPayReceiveCardUI$9(HoneyPayReceiveCardUI honeyPayReceiveCardUI, bdk bdk) {
        this.kmc = honeyPayReceiveCardUI;
        this.kme = bdk;
    }

    public final void aCb() {
        if (!bi.oW(this.kme.sdb)) {
            e.l(this.kmc.mController.tml, this.kme.sdb, false);
        }
        h.mEJ.h(15191, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
    }
}
