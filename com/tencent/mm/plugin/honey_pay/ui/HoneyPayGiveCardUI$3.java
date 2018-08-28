package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;

class HoneyPayGiveCardUI$3 implements OnClickListener {
    final /* synthetic */ HoneyPayGiveCardUI kls;

    HoneyPayGiveCardUI$3(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        this.kls = honeyPayGiveCardUI;
    }

    public final void onClick(View view) {
        HoneyPayGiveCardUI.c(this.kls).setVisibility(8);
        HoneyPayGiveCardUI.b(this.kls).setVisibility(0);
        HoneyPayGiveCardUI.b(this.kls).d(this.kls);
    }
}
