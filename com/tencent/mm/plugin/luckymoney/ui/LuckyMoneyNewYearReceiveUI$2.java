package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyNewYearReceiveUI$2 implements OnClickListener {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI kWg;

    LuckyMoneyNewYearReceiveUI$2(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        this.kWg = luckyMoneyNewYearReceiveUI;
    }

    public final void onClick(View view) {
        this.kWg.finish();
        h.mEJ.h(13079, new Object[]{Integer.valueOf(6), Integer.valueOf(2)});
    }
}
