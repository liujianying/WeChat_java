package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class j$4 implements a<Void, com.tencent.mm.ab.a.a<awv>> {
    final /* synthetic */ b dEk;
    final /* synthetic */ j oYS;

    j$4(j jVar, b bVar) {
        this.oYS = jVar;
        this.dEk = bVar;
    }

    private Void c(com.tencent.mm.ab.a.a<awv> aVar) {
        x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
        if (aVar.errType == 0 && aVar.errCode == 0) {
            i.oYM.a(((awv) aVar.dIv).rZU, true);
        }
        this.dEk.resume();
        return uQG;
    }
}
