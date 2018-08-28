package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyIndexUI$2 implements OnClickListener {
    final /* synthetic */ LuckyMoneyIndexUI kVs;

    LuckyMoneyIndexUI$2(LuckyMoneyIndexUI luckyMoneyIndexUI) {
        this.kVs = luckyMoneyIndexUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
        LuckyMoneyIndexUI.a(this.kVs, 0);
    }
}
