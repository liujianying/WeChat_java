package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class p$b implements e<y, Integer> {
    final /* synthetic */ p oZz;

    public p$b(p pVar) {
        this.oZz = pVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Integer num = (Integer) obj;
        o oVar = this.oZz.oZu;
        int intValue = num.intValue();
        oVar.eAc = g.cBF();
        oVar.eAc.cBE();
        oVar.oZm.a(new y(null, intValue == 1 ? 24 : 25), true, false);
        return null;
    }

    public final String xr() {
        return "Vending.UI";
    }
}
