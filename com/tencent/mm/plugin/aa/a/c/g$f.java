package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.f.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class g$f implements e<Boolean, Void> {
    final /* synthetic */ g eBH;

    public g$f(g gVar) {
        this.eBH = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        f fVar = this.eBH.eBA;
        String stringExtra = fVar.uPN.getStringExtra("bill_no");
        String stringExtra2 = fVar.uPN.getStringExtra("chatroom");
        int intExtra = fVar.uPN.getIntExtra("enter_scene", 0);
        x.i("MicroMsg.PaylistAAInteractor", "urgeAAPay");
        b cBF = g.cBF();
        cBF.cBE();
        new com.tencent.mm.plugin.aa.a.a.b(stringExtra, stringExtra2, intExtra).KM().d(new 2(fVar, cBF));
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
