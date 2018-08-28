package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.u;
import com.tencent.mm.wallet_core.ui.e;

class WxaLuckyMoneyPrepareUI$11 extends u {
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;
    final /* synthetic */ String kMu;

    WxaLuckyMoneyPrepareUI$11(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, String str) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.kMu = str;
    }

    public final void aBU() {
        if (WxaLuckyMoneyPrepareUI.a(this.kMq) == null) {
            x.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
        } else if (WxaLuckyMoneyPrepareUI.b(this.kMq).baC() != 0) {
            s.makeText(this.kMq.mController.tml, i.wallet_balance_save_input_invalid, 0).show();
        } else {
            int input = WxaLuckyMoneyPrepareUI.c(this.kMq).getInput();
            double input2 = WxaLuckyMoneyPrepareUI.b(this.kMq).getInput();
            String input3 = WxaLuckyMoneyPrepareUI.d(this.kMq).getInput();
            if (bi.oW(input3)) {
                if (bi.oW(this.kMu)) {
                    input3 = this.kMq.getString(i.lucky_money_default_wish);
                } else {
                    input3 = this.kMu;
                }
            }
            if (WxaLuckyMoneyPrepareUI.e(this.kMq) == a.kKZ) {
                WxaLuckyMoneyPrepareUI.a(this.kMq).b((int) e.C(input2), input, input3, WxaLuckyMoneyPrepareUI.f(this.kMq));
            } else if (WxaLuckyMoneyPrepareUI.e(this.kMq) == a.kLa) {
                WxaLuckyMoneyPrepareUI.a(this.kMq).c((int) e.C(input2), input, input3, WxaLuckyMoneyPrepareUI.f(this.kMq));
            }
        }
    }
}
