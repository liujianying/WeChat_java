package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class o$8 implements a {
    final /* synthetic */ o oZs;

    public o$8(o oVar) {
        this.oZs = oVar;
    }

    public final void bd(Object obj) {
        x.i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund interrupt: %s", new Object[]{obj});
        o.a(this.oZs).bNd();
        if (o.c(this.oZs) != null) {
            o.c(this.oZs).ct(obj);
        }
    }
}
