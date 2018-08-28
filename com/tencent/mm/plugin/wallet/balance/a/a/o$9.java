package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$9 implements a<Void, bft> {
    final /* synthetic */ o oZs;

    public o$9(o oVar) {
        this.oZs = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        bft bft = (bft) obj;
        x.i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund finish: %s", new Object[]{bft});
        o.a(this.oZs).bNd();
        o.a(this.oZs).bNe();
        if (o.c(this.oZs) != null) {
            o.c(this.oZs).v(new Object[]{bft});
        }
        return uQG;
    }
}
