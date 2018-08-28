package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.a.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class g$c implements e<Void, d<Long, String, String>> {
    final /* synthetic */ g eBH;

    public g$c(g gVar) {
        this.eBH = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        f fVar = this.eBH.eBA;
        long longValue = ((Long) dVar.get(0)).longValue();
        String str = (String) dVar.get(1);
        String str2 = (String) dVar.get(2);
        b cBF = g.cBF();
        String stringExtra = fVar.uPN.getStringExtra("bill_no");
        int intExtra = fVar.uPN.getIntExtra("enter_scene", 0);
        String stringExtra2 = fVar.uPN.getStringExtra("chatroom");
        cBF.cBE();
        new a(stringExtra, longValue, intExtra, stringExtra2, str, str2).KM().h(new f$1(fVar, cBF));
        return uQG;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
