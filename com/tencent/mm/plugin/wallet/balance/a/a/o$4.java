package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$4 implements a<bcp, bcp> {
    final /* synthetic */ o oZs;

    o$4(o oVar) {
        this.oZs = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        bcp bcp = (bcp) obj;
        o.a(this.oZs, bcp.qYx);
        o.a(this.oZs).bNd();
        x.i("MicroMsg.LqtSaveFetchLogic", "get tradeNo: %s", new Object[]{o.b(this.oZs)});
        return bcp;
    }
}
