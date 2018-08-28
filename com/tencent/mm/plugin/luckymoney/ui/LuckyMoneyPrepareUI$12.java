package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LuckyMoneyPrepareUI$12 extends c<pl> {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$12(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
        this.sFo = pl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        a aVar = ((pl) bVar).can.cao;
        if (aVar != null && aVar.bOq()) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "show 261 alert item");
            LuckyMoneyPrepareUI.a(this.kWX, true);
            h.a(this.kWX.mController.tml, aVar.bSc, "", aVar.kRv, aVar.kRu, new 1(this, aVar), new 2(this));
        }
        return false;
    }
}
