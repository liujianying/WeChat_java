package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.wallet_core.ui.h$a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

class WxaLuckyMoneyPrepareUI$14 implements h$a {
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;
    final /* synthetic */ SpannableString kMv;

    WxaLuckyMoneyPrepareUI$14(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, SpannableString spannableString) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.kMv = spannableString;
    }

    public final void onClick(View view) {
        int input = WxaLuckyMoneyPrepareUI.c(this.kMq).getInput();
        double input2 = WxaLuckyMoneyPrepareUI.b(this.kMq).getInput();
        WxaLuckyMoneyPrepareUI.a(this.kMq, a.kLa);
        WxaLuckyMoneyPrepareUI.b(this.kMq).setType(WxaLuckyMoneyPrepareUI.e(this.kMq));
        WxaLuckyMoneyPrepareUI.b(this.kMq).setShowGroupIcon(false);
        WxaLuckyMoneyPrepareUI.b(this.kMq).setTitle(this.kMq.getString(i.lucky_money_unit_amount_title));
        if (input2 > 0.0d && input > 0) {
            WxaLuckyMoneyPrepareUI.b(this.kMq).setAmount(e.A(input2 / ((double) input)));
        }
        WxaLuckyMoneyPrepareUI.b(this.kMq).setMaxAmount(g.kKP.kKR);
        WxaLuckyMoneyPrepareUI.g(this.kMq).setText(this.kMv);
    }
}
