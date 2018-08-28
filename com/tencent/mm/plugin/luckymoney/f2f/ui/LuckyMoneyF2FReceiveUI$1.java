package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LuckyMoneyF2FReceiveUI$1 implements OnClickListener {
    final /* synthetic */ LuckyMoneyF2FReceiveUI kON;

    LuckyMoneyF2FReceiveUI$1(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI) {
        this.kON = luckyMoneyF2FReceiveUI;
    }

    public final void onClick(View view) {
        LuckyMoneyF2FReceiveUI.a(this.kON).cancel();
        this.kON.finish();
    }
}
