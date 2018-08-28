package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.b;
import com.tencent.mm.sdk.platformtools.bi;

class LuckyMoneyBusiDetailUI$10 implements b {
    final /* synthetic */ LuckyMoneyBusiDetailUI kUw;

    LuckyMoneyBusiDetailUI$10(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        this.kUw = luckyMoneyBusiDetailUI;
    }

    public final void Gf(String str) {
        if (!bi.oW(str) && !bi.oW(LuckyMoneyBusiDetailUI.g(this.kUw))) {
            this.kUw.l(new ac(LuckyMoneyBusiDetailUI.h(this.kUw), str, LuckyMoneyBusiDetailUI.g(this.kUw), "v1.0"));
            LuckyMoneyBusiDetailUI.e(this.kUw);
        }
    }
}
