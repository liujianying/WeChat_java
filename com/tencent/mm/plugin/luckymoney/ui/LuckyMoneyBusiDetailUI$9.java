package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.ui.widget.MMEditText.a;

class LuckyMoneyBusiDetailUI$9 implements a {
    final /* synthetic */ LuckyMoneyBusiDetailUI kUw;

    LuckyMoneyBusiDetailUI$9(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        this.kUw = luckyMoneyBusiDetailUI;
    }

    public final void bbt() {
        if (LuckyMoneyBusiDetailUI.f(this.kUw).getVisibility() == 0) {
            LuckyMoneyBusiDetailUI.f(this.kUw).setVisibility(8);
        } else {
            this.kUw.mController.tml.finish();
        }
    }
}
