package com.tencent.mm.plugin.sns.j;

import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class b$b implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
    final /* synthetic */ b onn;

    public b$b(b bVar) {
        this.onn = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
        a aVar = this.onn.onk;
        String str = (String) eVar.get(0);
        ((Boolean) eVar.get(1)).booleanValue();
        aVar.h(str, ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
        return uQG;
    }

    public final String xr() {
        return "Vending.LOGIC";
    }

    public final c<Void> b(String str, boolean z, boolean z2, int i) {
        return g.a(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).c(this);
    }
}
