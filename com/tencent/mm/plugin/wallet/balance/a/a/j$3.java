package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class j$3 implements a<Void, com.tencent.mm.ab.a.a<awx>> {
    final /* synthetic */ b dEk;
    final /* synthetic */ j oYS;

    j$3(j jVar, b bVar) {
        this.oYS = jVar;
        this.dEk = bVar;
    }

    private Void c(com.tencent.mm.ab.a.a<awx> aVar) {
        x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem end, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            l.bMQ().a((awx) aVar.dIv);
            i.oYM.a(((awx) aVar.dIv).rZU, false);
        }
        this.dEk.resume();
        return uQG;
    }
}
