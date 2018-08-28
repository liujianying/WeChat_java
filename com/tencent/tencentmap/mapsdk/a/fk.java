package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class fk extends gc {
    private static Map c;
    public Map a = null;
    public long b = 0;

    public final void a(ga gaVar) {
        if (c == null) {
            c = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add("");
            c.put(valueOf, arrayList);
        }
        this.a = (Map) gaVar.a(c, 0, false);
        this.b = gaVar.a(this.b, 1, false);
    }

    public final void a(gb gbVar) {
        if (this.a != null) {
            gbVar.a(this.a, 0);
        }
        gbVar.a(this.b, 1);
    }
}
