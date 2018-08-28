package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$2 implements a<Void, com.tencent.mm.ab.a.a<awx>> {
    final /* synthetic */ o oZs;

    o$2(o oVar) {
        this.oZs = oVar;
    }

    private Void c(com.tencent.mm.ab.a.a<awx> aVar) {
        x.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            l.bMQ().a((awx) aVar.dIv);
            i.oYM.a(((awx) aVar.dIv).rZU, false);
        }
        if (o.c(this.oZs) != null) {
            o.c(this.oZs).resume();
        }
        return uQG;
    }
}
