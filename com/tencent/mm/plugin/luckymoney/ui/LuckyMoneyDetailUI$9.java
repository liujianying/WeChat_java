package com.tencent.mm.plugin.luckymoney.ui;

class LuckyMoneyDetailUI$9 implements Runnable {
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$9(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.kVo = luckyMoneyDetailUI;
    }

    public final void run() {
        LuckyMoneyDetailUI.w(this.kVo);
        LuckyMoneyDetailUI.x(this.kVo).setVisibility(0);
    }
}
