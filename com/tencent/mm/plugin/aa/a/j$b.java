package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class j$b implements e<Boolean, d<String, Integer, String>> {
    final /* synthetic */ j eAx;

    public j$b(j jVar) {
        this.eAx = jVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        i iVar = this.eAx.eAu;
        String str = (String) dVar.get(0);
        int intValue = ((Integer) dVar.get(1)).intValue();
        String str2 = (String) dVar.get(2);
        iVar.dIz = g.cBF();
        if (bi.oW(str)) {
            iVar.dIz.ct(Boolean.valueOf(false));
        } else {
            com.tencent.mm.plugin.aa.a.a.e eVar = new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(eVar, 0);
            x.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", new Object[]{str, Integer.valueOf(intValue)});
            iVar.dIz = g.cBL();
        }
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
