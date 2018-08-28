package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.o.10;
import com.tencent.mm.plugin.wallet.balance.a.a.o.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public class p$d implements e<Void, c<Integer, Integer>> {
    final /* synthetic */ p oZz;

    public p$d(p pVar) {
        this.oZz = pVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        o oVar = this.oZz.oZu;
        int intValue = ((Integer) cVar.get(0)).intValue();
        int intValue2 = ((Integer) cVar.get(1)).intValue();
        x.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)});
        oVar.eAc = g.cBF();
        oVar.eAc.cBE();
        if (intValue == 1) {
            new b(intValue2).KM().b(new 10(oVar));
        } else {
            new c(intValue2).KM().b(new 2(oVar));
        }
        return uQG;
    }

    public final String xr() {
        return "Vending.UI";
    }

    public final com.tencent.mm.vending.g.c<Void> dX(int i, int i2) {
        return g.v(Integer.valueOf(i), Integer.valueOf(i2)).c(this);
    }
}
