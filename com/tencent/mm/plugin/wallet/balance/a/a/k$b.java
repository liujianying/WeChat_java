package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class k$b implements e<bdo, Void> {
    final /* synthetic */ k oYY;

    public k$b(k kVar) {
        this.oYY = kVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        j jVar = this.oYY.oYT;
        b cBF = g.cBF();
        cBF.cBE();
        if (!ao.isNetworkConnected(ad.getContext())) {
            cBF.ct(Boolean.valueOf(false));
        }
        new g().KM().h(new j$1(jVar, cBF));
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
