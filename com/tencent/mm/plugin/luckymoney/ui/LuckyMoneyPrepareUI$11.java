package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$11 implements a {
    final /* synthetic */ SpannableString kMv;
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$11(LuckyMoneyPrepareUI luckyMoneyPrepareUI, SpannableString spannableString) {
        this.kWX = luckyMoneyPrepareUI;
        this.kMv = spannableString;
    }

    public final void onClick(View view) {
        int input = LuckyMoneyPrepareUI.a(this.kWX).getInput();
        double input2 = LuckyMoneyPrepareUI.b(this.kWX).getInput();
        LuckyMoneyPrepareUI.a(this.kWX, 0);
        LuckyMoneyPrepareUI.b(this.kWX).setType(LuckyMoneyPrepareUI.c(this.kWX));
        LuckyMoneyPrepareUI.b(this.kWX).setShowGroupIcon(false);
        LuckyMoneyPrepareUI.b(this.kWX).setTitle(this.kWX.getString(i.lucky_money_unit_amount_title));
        if (input2 > 0.0d && input > 0) {
            LuckyMoneyPrepareUI.b(this.kWX).setAmount(e.A(input2 / ((double) input)));
        }
        LuckyMoneyPrepareUI.b(this.kWX).setMaxAmount(LuckyMoneyPrepareUI.d(this.kWX).kKR);
        LuckyMoneyPrepareUI.e(this.kWX).setText(this.kMv);
        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.kWX)), Integer.valueOf(3)});
    }
}
