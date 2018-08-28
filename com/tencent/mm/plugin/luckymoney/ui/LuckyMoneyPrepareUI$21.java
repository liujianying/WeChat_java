package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LuckyMoneyPrepareUI$21 implements OnClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$21(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final void onClick(View view) {
        LuckyMoneyPrepareUI.u(this.kWX).setVisibility(8);
        this.kWX.bbp();
    }
}
