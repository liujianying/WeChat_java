package com.tencent.mm.plugin.luckymoney.sns;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsLuckyMoneyPrepareUI$17 implements a {
    final /* synthetic */ SnsLuckyMoneyPrepareUI kTy;

    SnsLuckyMoneyPrepareUI$17(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.kTy = snsLuckyMoneyPrepareUI;
    }

    public final boolean vD() {
        double d;
        if (this.kTy.kTn.baC() == 3 || this.kTy.kMf.baC() == 3) {
            d = 0.0d;
        } else {
            int input = this.kTy.kMf.getInput();
            d = this.kTy.kTn.getInput();
            if (SnsLuckyMoneyPrepareUI.a(this.kTy) == 0) {
                d *= (double) input;
            }
        }
        if (d == 0.0d || d > SnsLuckyMoneyPrepareUI.b(this.kTy).kKT || SnsLuckyMoneyPrepareUI.i(this.kTy).bbw()) {
            this.kTy.kMi.setClickable(false);
            this.kTy.kMi.setEnabled(false);
        } else {
            this.kTy.kMi.setClickable(true);
            this.kTy.kMi.setEnabled(true);
        }
        x.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(this.kTy).bbw());
        SnsLuckyMoneyPrepareUI.j(this.kTy).ciq();
        return false;
    }
}
