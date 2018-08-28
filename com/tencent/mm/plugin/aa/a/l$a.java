package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import java.util.Map;

public class l$a implements e<Boolean, c<Integer, Map<String, Object>>> {
    final /* synthetic */ l eAM;

    public l$a(l lVar) {
        this.eAM = lVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        this.eAM.eAJ.c(((Integer) cVar.get(0)).intValue(), (Map) cVar.get(1));
        return null;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }
}
