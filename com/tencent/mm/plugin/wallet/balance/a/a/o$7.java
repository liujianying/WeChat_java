package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.bdm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$7 implements a<Void, bdm> {
    final /* synthetic */ o oZs;

    public o$7(o oVar) {
        this.oZs = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        bdm bdm = (bdm) obj;
        x.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult finish: %s", new Object[]{bdm});
        o.a(this.oZs).bNd();
        o.a(this.oZs).bNe();
        if (o.c(this.oZs) != null) {
            o.c(this.oZs).v(new Object[]{bdm});
        }
        return uQG;
    }
}
