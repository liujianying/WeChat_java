package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyPrepareUI$18 implements OnClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$18(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.kWX)), Integer.valueOf(9)});
        Intent intent = new Intent();
        intent.setClass(this.kWX.mController.tml, LuckyMoneyCanShareListUI.class);
        this.kWX.startActivity(intent);
    }
}
