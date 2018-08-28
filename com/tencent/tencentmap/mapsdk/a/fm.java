package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class fm extends gc {
    private static Map c;
    public Map a = null;
    public int b = 0;

    public final void a(ga gaVar) {
        if (c == null) {
            c = new HashMap();
            c.put(Integer.valueOf(0), Byte.valueOf((byte) 0));
        }
        this.a = (Map) gaVar.a(c, 0, true);
        this.b = gaVar.a(this.b, 1, true);
    }

    public final void a(gb gbVar) {
        gbVar.a(this.a, 0);
        gbVar.a(this.b, 1);
    }
}
