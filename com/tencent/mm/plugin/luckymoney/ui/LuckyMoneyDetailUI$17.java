package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.ui.widget.MMEditText.a;

class LuckyMoneyDetailUI$17 implements a {
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$17(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.kVo = luckyMoneyDetailUI;
    }

    public final void bbt() {
        if (LuckyMoneyDetailUI.o(this.kVo).getVisibility() == 0) {
            LuckyMoneyDetailUI.o(this.kVo).setVisibility(8);
        } else {
            this.kVo.mController.tml.finish();
        }
    }
}
