package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.ui.base.MMLoadMoreListView.a;

class LuckyMoneyMyRecordUI$5 implements a {
    final /* synthetic */ LuckyMoneyMyRecordUI kVL;

    LuckyMoneyMyRecordUI$5(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.kVL = luckyMoneyMyRecordUI;
    }

    public final void aAU() {
        if (!this.kVL.kUg.baU()) {
            LuckyMoneyMyRecordUI.g(this.kVL);
        }
        if (LuckyMoneyMyRecordUI.h(this.kVL) && !LuckyMoneyMyRecordUI.i(this.kVL)) {
            LuckyMoneyMyRecordUI.d(this.kVL);
        }
    }
}
