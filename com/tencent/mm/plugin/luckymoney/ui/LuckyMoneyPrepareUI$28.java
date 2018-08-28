package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.y;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.u;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$28 extends u {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$28(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final void aBU() {
        h.mEJ.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.kWX)), Integer.valueOf(4));
        h.mEJ.h(15511, Integer.valueOf(LuckyMoneyPrepareUI.g(this.kWX)), Integer.valueOf(2));
        if (LuckyMoneyPrepareUI.b(this.kWX).baC() != 0) {
            s.makeText(this.kWX.mController.tml, i.wallet_balance_save_input_invalid, 0).show();
            return;
        }
        long C;
        int input = LuckyMoneyPrepareUI.a(this.kWX).getInput();
        double input2 = LuckyMoneyPrepareUI.b(this.kWX).getInput();
        long j = 0;
        if (LuckyMoneyPrepareUI.c(this.kWX) == 1) {
            C = e.C(input2);
            g.Ek();
            g.Ei().DT().set(356354, Integer.valueOf(input));
        } else {
            C = e.C(((double) input) * input2);
            j = e.C(input2);
            g.Ek();
            g.Ei().DT().set(356353, Integer.valueOf(input));
        }
        String input3 = LuckyMoneyPrepareUI.h(this.kWX).getInput();
        if (bi.oW(input3)) {
            input3 = bi.oW(LuckyMoneyPrepareUI.i(this.kWX)) ? this.kWX.getString(i.lucky_money_default_wish) : LuckyMoneyPrepareUI.i(this.kWX);
        }
        if (LuckyMoneyPrepareUI.j(this.kWX) == 2) {
            this.kWX.b(new c(input, (int) C, LuckyMoneyPrepareUI.c(this.kWX), (int) j), false);
        } else {
            String stringExtra = this.kWX.getIntent().getStringExtra("key_username");
            if (LuckyMoneyPrepareUI.g(this.kWX) == 1) {
                l aeVar;
                x.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB");
                if (!LuckyMoneyPrepareUI.k(this.kWX) || bi.oW(stringExtra)) {
                    aeVar = new ae(input, C, j, LuckyMoneyPrepareUI.c(this.kWX), input3, o.baX(), null, null, q.GF(), q.GH(), LuckyMoneyPrepareUI.l(this.kWX));
                } else {
                    aeVar = new ae(input, C, j, LuckyMoneyPrepareUI.c(this.kWX), input3, o.baX(), stringExtra, o.gS(stringExtra), q.GF(), q.GH(), LuckyMoneyPrepareUI.l(this.kWX));
                }
                this.kWX.b(aeVar, false);
            } else {
                l yVar;
                x.i("MicroMsg.LuckyMoneyPrepareUI", "currency=" + LuckyMoneyPrepareUI.g(this.kWX));
                this.kWX.jr(1645);
                if (!LuckyMoneyPrepareUI.k(this.kWX) || bi.oW(stringExtra)) {
                    yVar = new y(input, C, j, LuckyMoneyPrepareUI.c(this.kWX), input3, null, o.baX(), q.GF(), LuckyMoneyPrepareUI.g(this.kWX));
                } else {
                    yVar = new y(input, C, j, LuckyMoneyPrepareUI.c(this.kWX), input3, stringExtra, o.baX(), q.GF(), LuckyMoneyPrepareUI.g(this.kWX));
                }
                this.kWX.b(yVar, false);
            }
        }
        if (LuckyMoneyPrepareUI.m(this.kWX) != null) {
            LuckyMoneyPrepareUI.m(this.kWX).show();
        } else {
            LuckyMoneyPrepareUI.a(this.kWX, com.tencent.mm.wallet_core.ui.g.a(this.kWX.mController.tml, true, new 1(this)));
        }
    }
}
