package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.b;
import com.tencent.mm.sdk.platformtools.bi;

class LuckyMoneyDetailUI$18 implements b {
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$18(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.kVo = luckyMoneyDetailUI;
    }

    public final void Gf(String str) {
        if (!bi.oW(str) && !bi.oW(LuckyMoneyDetailUI.p(this.kVo))) {
            this.kVo.l(new ac(LuckyMoneyDetailUI.q(this.kVo), str, LuckyMoneyDetailUI.p(this.kVo), "v1.0"));
            LuckyMoneyDetailUI.n(this.kVo);
        }
    }
}
