package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class fj extends gc {
    private static ArrayList e;
    private static Map f;
    public ArrayList a = null;
    public String b = "";
    private int c = 0;
    private Map d = null;

    public final void a(ga gaVar) {
        this.c = gaVar.a(this.c, 0, true);
        if (e == null) {
            e = new ArrayList();
            e.add("");
        }
        this.a = (ArrayList) gaVar.a(e, 1, true);
        this.b = gaVar.a(2, false);
        if (f == null) {
            f = new HashMap();
            f.put("", "");
        }
        this.d = (Map) gaVar.a(f, 3, false);
    }

    public final void a(gb gbVar) {
        gbVar.a(this.c, 0);
        gbVar.a(this.a, 1);
        if (this.b != null) {
            gbVar.a(this.b, 2);
        }
        if (this.d != null) {
            gbVar.a(this.d, 3);
        }
    }
}
