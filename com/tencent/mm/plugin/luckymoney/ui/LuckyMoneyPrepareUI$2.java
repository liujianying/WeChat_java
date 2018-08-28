package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class LuckyMoneyPrepareUI$2 implements c {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$2(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final void a(l lVar) {
        lVar.add(0, 0, 0, this.kWX.getString(i.lucky_money_check_mine_title_opt));
        lVar.add(0, 1, 0, this.kWX.getString(i.wallet_index_ui_opt_common_questions));
    }
}
