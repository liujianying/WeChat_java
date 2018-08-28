package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyPrepareUI$20 implements OnClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$20(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.kWX)), Integer.valueOf(6)});
        o.a(this.kWX, LuckyMoneyPrepareUI.c(this.kWX), LuckyMoneyPrepareUI.t(this.kWX), true);
        LuckyMoneyPrepareUI.u(this.kWX).postDelayed(new 1(this), 100);
    }
}
