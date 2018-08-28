package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyPrepareUI$29 implements a {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$29(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final boolean vD() {
        double d;
        if (LuckyMoneyPrepareUI.b(this.kWX).baC() == 3 || LuckyMoneyPrepareUI.a(this.kWX).baC() == 3) {
            d = 0.0d;
        } else {
            int input = LuckyMoneyPrepareUI.a(this.kWX).getInput();
            d = LuckyMoneyPrepareUI.b(this.kWX).getInput();
            if (LuckyMoneyPrepareUI.c(this.kWX) == 0) {
                d *= (double) input;
            }
        }
        if (d == 0.0d || d > LuckyMoneyPrepareUI.d(this.kWX).kKT || LuckyMoneyPrepareUI.p(this.kWX).bbw()) {
            LuckyMoneyPrepareUI.q(this.kWX).setClickable(false);
            LuckyMoneyPrepareUI.q(this.kWX).setEnabled(false);
        } else {
            LuckyMoneyPrepareUI.q(this.kWX).setClickable(true);
            LuckyMoneyPrepareUI.q(this.kWX).setEnabled(true);
        }
        x.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + LuckyMoneyPrepareUI.p(this.kWX).bbw());
        LuckyMoneyPrepareUI.r(this.kWX).ciq();
        return false;
    }
}
