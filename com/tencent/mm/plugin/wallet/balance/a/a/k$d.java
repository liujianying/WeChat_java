package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.j.3;
import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class k$d implements e<awx, Integer> {
    final /* synthetic */ k oYY;

    public k$d(k kVar) {
        this.oYY = kVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Integer num = (Integer) obj;
        j jVar = this.oYY.oYT;
        x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem, accountType: %s", Integer.valueOf(num.intValue()));
        b cBF = g.cBF();
        cBF.cBE();
        new c(r1).KM().b(new 3(jVar, cBF));
        return null;
    }

    public final String xr() {
        return "Vending.UI";
    }
}
