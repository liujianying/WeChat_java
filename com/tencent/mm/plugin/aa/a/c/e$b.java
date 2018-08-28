package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import java.util.Map;

public class e$b implements e<Boolean, c<Integer, Map<String, Object>>> {
    final /* synthetic */ e eBv;

    public e$b(e eVar) {
        this.eBv = eVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        d dVar = this.eBv.eBr;
        int intValue = ((Integer) cVar.get(0)).intValue();
        Map map = (Map) cVar.get(1);
        int intExtra = dVar.uPN.getIntExtra("enter_scene", 1);
        if (intExtra == 1) {
            map.put(k.eAD, Integer.valueOf(a.ezF));
        } else if (intExtra == 2) {
            map.put(k.eAD, Integer.valueOf(a.ezG));
        } else if (intExtra == 3) {
            map.put(k.eAD, Integer.valueOf(a.ezH));
        }
        g.a(g.v(Integer.valueOf(intValue), map).c(dVar.eBp.eAK));
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
