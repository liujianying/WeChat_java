package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public class g$a implements e<c<String, String>, com.tencent.mm.vending.j.e<String, Long, Integer, String>> {
    final /* synthetic */ g eAt;

    public g$a(g gVar) {
        this.eAt = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
        f fVar = this.eAt.eAr;
        String str = (String) eVar.get(0);
        long longValue = ((Long) eVar.get(1)).longValue();
        int intValue = ((Integer) eVar.get(2)).intValue();
        String str2 = (String) eVar.get(3);
        if (fVar.eAq) {
            x.e("MicroMsg.AAPayLogic", "aaPay, isPaying!");
        } else {
            i iVar = new i(str, longValue, intValue, str2);
            g.Ek();
            g.Eh().dpP.a(iVar, 0);
            fVar.eAc = com.tencent.mm.vending.g.g.cBL();
            fVar.eAq = true;
        }
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
