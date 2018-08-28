package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class g$e implements e<Void, d<String, String, String>> {
    final /* synthetic */ g eBH;

    public g$e(g gVar) {
        this.eBH = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        f fVar = this.eBH.eBA;
        String str = (String) dVar.get(1);
        h.c(str, fVar.uPN.getStringExtra("chatroom"), fVar.uPN.getStringExtra("bill_no"), (String) dVar.get(0), (String) dVar.get(2));
        return uQG;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
