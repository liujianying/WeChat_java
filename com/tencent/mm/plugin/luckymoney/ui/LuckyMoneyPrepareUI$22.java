package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$22 implements a {
    final /* synthetic */ SpannableString kMw;
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$22(LuckyMoneyPrepareUI luckyMoneyPrepareUI, SpannableString spannableString) {
        this.kWX = luckyMoneyPrepareUI;
        this.kMw = spannableString;
    }

    public final void onClick(View view) {
        int input = LuckyMoneyPrepareUI.a(this.kWX).getInput();
        double input2 = LuckyMoneyPrepareUI.b(this.kWX).getInput();
        LuckyMoneyPrepareUI.a(this.kWX, 1);
        LuckyMoneyPrepareUI.b(this.kWX).setType(LuckyMoneyPrepareUI.c(this.kWX));
        LuckyMoneyPrepareUI.b(this.kWX).setMaxAmount(LuckyMoneyPrepareUI.d(this.kWX).kKT);
        LuckyMoneyPrepareUI.b(this.kWX).setTitle(this.kWX.getString(i.lucky_money_total_amount_title));
        LuckyMoneyPrepareUI.b(this.kWX).setShowGroupIcon(true);
        if (input2 > 0.0d && input > 0) {
            LuckyMoneyPrepareUI.b(this.kWX).setAmount(e.A(input2 * ((double) input)));
        }
        LuckyMoneyPrepareUI.e(this.kWX).setText(this.kMw);
        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.kWX)), Integer.valueOf(2)});
    }
}
