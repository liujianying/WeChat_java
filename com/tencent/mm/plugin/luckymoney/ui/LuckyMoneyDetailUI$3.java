package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LuckyMoneyDetailUI$3 implements OnClickListener {
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$3(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.kVo = luckyMoneyDetailUI;
    }

    public final void onClick(View view) {
        LuckyMoneyDetailUI.o(this.kVo).setVisibility(0);
    }
}
