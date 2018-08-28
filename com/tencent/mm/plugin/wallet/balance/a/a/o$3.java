package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$3 implements a<Void, bcp> {
    final /* synthetic */ o oZs;
    final /* synthetic */ Bankcard oZt;

    o$3(o oVar, Bankcard bankcard) {
        this.oZs = oVar;
        this.oZt = bankcard;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.LqtSaveFetchLogic", "doSaveLqt, prepayid: %s", new Object[]{((bcp) obj).seN});
        o.a(this.oZs, r6.seN, this.oZt);
        return null;
    }
}
