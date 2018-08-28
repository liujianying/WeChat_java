package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.j.4;
import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class k$c implements e<awv, Integer> {
    final /* synthetic */ k oYY;

    public k$c(k kVar) {
        this.oYY = kVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Integer num = (Integer) obj;
        j jVar = this.oYY.oYT;
        x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase, accountType: %s", new Object[]{Integer.valueOf(num.intValue())});
        b cBF = g.cBF();
        cBF.cBE();
        new b(r1).KM().b(new 4(jVar, cBF));
        return null;
    }

    public final String xr() {
        return "Vending.UI";
    }
}
