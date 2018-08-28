package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public class e$c implements e<d<Boolean, String, Long>, Map<String, Object>> {
    final /* synthetic */ e eBv;

    public e$c(e eVar) {
        this.eBv = eVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Map map = (Map) obj;
        a aVar = this.eBv.eBr;
        int intExtra = aVar.uPN.getIntExtra("enter_scene", 1);
        if (intExtra == 1) {
            map.put(k.eAD, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ezF));
        } else if (intExtra == 2) {
            map.put(k.eAD, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ezG));
        } else if (intExtra == 3) {
            map.put(k.eAD, Integer.valueOf(com.tencent.mm.plugin.aa.a.a.ezH));
        }
        g.a(g.cx(map).c(aVar.eBp.eAL));
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
