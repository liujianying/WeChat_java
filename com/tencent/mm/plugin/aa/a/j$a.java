package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class j$a implements e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>> {
    final /* synthetic */ j eAx;

    public j$a(j jVar) {
        this.eAx = jVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
        i iVar = this.eAx.eAu;
        String str = (String) eVar.get(0);
        int intValue = ((Integer) eVar.get(1)).intValue();
        String str2 = (String) eVar.get(2);
        long longValue = ((Long) eVar.get(3)).longValue();
        iVar.dIz = g.cBF();
        iVar.bJC = longValue;
        if (bi.oW(str)) {
            iVar.dIz.ct(Boolean.valueOf(false));
        } else {
            com.tencent.mm.plugin.aa.a.a.e eVar2 = new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(eVar2, 0);
            x.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", new Object[]{str, Integer.valueOf(intValue)});
            iVar.dIz = g.cBL();
        }
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
