package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class g$b implements e<Boolean, Void> {
    final /* synthetic */ g eBH;

    public g$b(g gVar) {
        this.eBH = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        f fVar = this.eBH.eBA;
        String stringExtra = fVar.uPN.getStringExtra("bill_no");
        int intExtra = fVar.uPN.getIntExtra("enter_scene", 0);
        g.a(g.a(stringExtra, Integer.valueOf(intExtra), fVar.uPN.getStringExtra("chatroom")).c(fVar.eBy.eAv));
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
