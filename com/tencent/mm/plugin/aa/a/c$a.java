package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public class c$a implements e<v, f<String, Integer, String, String, Integer>> {
    final /* synthetic */ c eAf;

    public c$a(c cVar) {
        this.eAf = cVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        f fVar = (f) obj;
        b bVar = this.eAf.eAd;
        j jVar = new j((String) fVar.get(0), ((Integer) fVar.get(1)).intValue(), (String) fVar.get(2), (String) fVar.get(3), ((Integer) fVar.get(4)).intValue());
        g.Ek();
        g.Eh().dpP.a(jVar, 0);
        bVar.eAc = com.tencent.mm.vending.g.g.cBL();
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
