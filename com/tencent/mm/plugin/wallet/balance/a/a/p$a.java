package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.o.5;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class p$a implements e<bft, d<Integer, Integer, fe>> {
    final /* synthetic */ p oZz;

    public p$a(p pVar) {
        this.oZz = pVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        o oVar = this.oZz.oZu;
        int intValue = ((Integer) dVar.get(0)).intValue();
        int intValue2 = ((Integer) dVar.get(1)).intValue();
        fe feVar = (fe) dVar.get(2);
        x.i("MicroMsg.LqtSaveFetchLogic", "fetchLqt, accountType: %s", new Object[]{Integer.valueOf(intValue2)});
        x.d("MicroMsg.LqtSaveFetchLogic", "fetchLqt, amount: %s, accountType: %s", new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)});
        oVar.oZp = intValue;
        oVar.accountType = intValue2;
        oVar.oZm.jh(true);
        g.a(g.a(Integer.valueOf(intValue), feVar, Integer.valueOf(intValue2)).c(oVar.oZl.oZg).c(new 5(oVar)));
        return null;
    }

    public final String xr() {
        return "Vending.UI";
    }
}
