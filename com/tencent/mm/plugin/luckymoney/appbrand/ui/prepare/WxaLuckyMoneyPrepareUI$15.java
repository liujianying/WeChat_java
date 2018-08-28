package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.wallet_core.ui.e;

class WxaLuckyMoneyPrepareUI$15 implements a {
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;
    final /* synthetic */ SpannableString kMw;

    WxaLuckyMoneyPrepareUI$15(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, SpannableString spannableString) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.kMw = spannableString;
    }

    public final void onClick(View view) {
        int input = WxaLuckyMoneyPrepareUI.c(this.kMq).getInput();
        double input2 = WxaLuckyMoneyPrepareUI.b(this.kMq).getInput();
        WxaLuckyMoneyPrepareUI.a(this.kMq, h.a.kKZ);
        WxaLuckyMoneyPrepareUI.b(this.kMq).setType(WxaLuckyMoneyPrepareUI.e(this.kMq));
        WxaLuckyMoneyPrepareUI.b(this.kMq).setMaxAmount(g.kKP.kKT);
        WxaLuckyMoneyPrepareUI.b(this.kMq).setTitle(this.kMq.getString(a$i.lucky_money_total_amount_title));
        WxaLuckyMoneyPrepareUI.b(this.kMq).setShowGroupIcon(true);
        if (input2 > 0.0d && input > 0) {
            WxaLuckyMoneyPrepareUI.b(this.kMq).setAmount(e.A(input2 * ((double) input)));
        }
        WxaLuckyMoneyPrepareUI.g(this.kMq).setText(this.kMw);
    }
}
