package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class g$d implements e<v, Void> {
    final /* synthetic */ g eBH;

    public g$d(g gVar) {
        this.eBH = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        f fVar = this.eBH.eBA;
        String stringExtra = fVar.uPN.getStringExtra("bill_no");
        int intExtra = fVar.uPN.getIntExtra("enter_scene", 0);
        String stringExtra2 = fVar.uPN.getStringExtra("chatroom");
        String stringExtra3 = fVar.uPN.getStringExtra("key_sign");
        int intExtra2 = fVar.uPN.getIntExtra("key_ver", 0);
        x.i("MicroMsg.PaylistAAInteractor", "getPayListDetail, billNo: %s, scene: %s, chatRoom: %s", new Object[]{stringExtra, Integer.valueOf(intExtra), stringExtra2});
        g.a(g.a(stringExtra, Integer.valueOf(intExtra), stringExtra2, stringExtra3, Integer.valueOf(intExtra2)).c(fVar.eBw.eAe));
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
