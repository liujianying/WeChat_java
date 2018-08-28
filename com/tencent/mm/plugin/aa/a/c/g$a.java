package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class g$a implements e<o, Long> {
    final /* synthetic */ g eBH;

    public g$a(g gVar) {
        this.eBH = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Long l = (Long) obj;
        f fVar = this.eBH.eBA;
        long longValue = l.longValue();
        String stringExtra = fVar.uPN.getStringExtra("bill_no");
        String stringExtra2 = fVar.uPN.getStringExtra("chatroom");
        int i = fVar.uPN.getIntExtra("enter_scene", 0) == 1 ? a.ezU : a.ezV;
        x.i("MicroMsg.PaylistAAInteractor", "aaPay, payAmount: %s, billNo: %s, chatroom: %s", new Object[]{Long.valueOf(longValue), stringExtra, stringExtra2});
        g.a(g.a(stringExtra, Long.valueOf(longValue), Integer.valueOf(i), stringExtra2).c(fVar.eBx.eAs));
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
