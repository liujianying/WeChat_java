package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class n$a implements e<bbl, d<Integer, fe, Integer>> {
    final /* synthetic */ n oZh;

    public n$a(n nVar) {
        this.oZh = nVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        m mVar = this.oZh.oZc;
        int intValue = ((Integer) dVar.get(0)).intValue();
        fe feVar = (fe) dVar.get(1);
        x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, accountType: %s", new Object[]{Integer.valueOf(((Integer) dVar.get(2)).intValue())});
        x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, redeemFee: %s", new Object[]{Integer.valueOf(intValue)});
        b cBF = g.cBF();
        cBF.cBE();
        new d(intValue, feVar, r1).KM().b(new m$4(mVar, cBF));
        return null;
    }

    public final String xr() {
        return "Vending.UI";
    }
}
