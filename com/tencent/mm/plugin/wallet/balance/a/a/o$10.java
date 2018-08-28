package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$10 implements a<Void, com.tencent.mm.ab.a.a<awv>> {
    final /* synthetic */ o oZs;

    o$10(o oVar) {
        this.oZs = oVar;
    }

    private Void c(com.tencent.mm.ab.a.a<awv> aVar) {
        x.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            i.oYM.a(((awv) aVar.dIv).rZU, true);
        }
        if (o.c(this.oZs) != null) {
            o.c(this.oZs).resume();
        }
        return uQG;
    }
}
