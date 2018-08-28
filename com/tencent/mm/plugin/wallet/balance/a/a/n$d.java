package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class n$d implements e<bcp, com.tencent.mm.vending.j.e<String, String, Integer, Integer>> {
    final /* synthetic */ n oZh;

    public n$d(n nVar) {
        this.oZh = nVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
        m mVar = this.oZh.oZc;
        String str = (String) eVar.get(0);
        String str2 = (String) eVar.get(1);
        int intValue = ((Integer) eVar.get(2)).intValue();
        x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, accountType: %s, spid: %s", new Object[]{str, Integer.valueOf(((Integer) eVar.get(3)).intValue()), str2});
        x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, purchaseFee: %s", new Object[]{str, Integer.valueOf(intValue)});
        b cBF = g.cBF();
        cBF.cBE();
        new e(str, str2, intValue, r2).KM().f(new m$1(mVar, cBF));
        return null;
    }

    public final String xr() {
        return "Vending.UI";
    }
}
