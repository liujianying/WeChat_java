package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.a;

class HoneyPayGiveCardUI$5 implements a {
    final /* synthetic */ HoneyPayGiveCardUI kls;

    HoneyPayGiveCardUI$5(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        this.kls = honeyPayGiveCardUI;
    }

    public final void fI(boolean z) {
        if (z) {
            HoneyPayGiveCardUI.a(this.kls, HoneyPayGiveCardUI.e(this.kls), HoneyPayGiveCardUI.f(this.kls));
            return;
        }
        HoneyPayGiveCardUI.e(this.kls).scrollTo(0, 0);
        HoneyPayGiveCardUI.b(this.kls).bqm();
        if (bi.oW(HoneyPayGiveCardUI.b(this.kls).getText())) {
            HoneyPayGiveCardUI.b(this.kls).setVisibility(8);
            HoneyPayGiveCardUI.c(this.kls).setVisibility(0);
            HoneyPayGiveCardUI.g(this.kls);
            HoneyPayGiveCardUI.h(this.kls);
        }
    }
}
