package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.8;

class WxaLuckyMoneyPrepareUI$8$1 implements Runnable {
    final /* synthetic */ 8 kMt;

    WxaLuckyMoneyPrepareUI$8$1(8 8) {
        this.kMt = 8;
    }

    public final void run() {
        this.kMt.kMq.kMk.setVisibility(0);
        this.kMt.eCI.requestFocus();
        if (this.kMt.kMq.mKeyboard != null) {
            this.kMt.kMq.mKeyboard.setInputEditText(this.kMt.eCH);
        }
        WxaLuckyMoneyPrepareUI.b(this.kMt.kMq, this.kMt.eCJ);
    }
}
