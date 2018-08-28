package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.25;

class LuckyMoneyPrepareUI$25$1 implements Runnable {
    final /* synthetic */ 25 kXc;

    LuckyMoneyPrepareUI$25$1(25 25) {
        this.kXc = 25;
    }

    public final void run() {
        this.kXc.kWX.kMk.setVisibility(0);
        this.kXc.eCI.requestFocus();
        if (this.kXc.kWX.mKeyboard != null) {
            this.kXc.kWX.mKeyboard.setInputEditText(this.kXc.eCH);
        }
        LuckyMoneyPrepareUI.b(this.kXc.kWX, this.kXc.eCJ);
    }
}
