package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class fi extends gc {
    private static Map h;
    private static fk i;
    private static fg j;
    private static Map k;
    private static Map l;
    public Map a = null;
    public fk b = null;
    public fg c = null;
    private String d = "";
    private int e = 0;
    private Map f = null;
    private Map g = null;

    public final void a(ga gaVar) {
        this.d = gaVar.a(0, true);
        this.e = gaVar.a(this.e, 1, true);
        if (h == null) {
            h = new HashMap();
            fj fjVar = new fj();
            h.put("", fjVar);
        }
        this.a = (Map) gaVar.a(h, 2, true);
        if (i == null) {
            i = new fk();
        }
        this.b = (fk) gaVar.a(i, 3, false);
        if (j == null) {
            j = new fg();
        }
        this.c = (fg) gaVar.a(j, 4, false);
        if (k == null) {
            k = new HashMap();
            k.put("", "");
        }
        this.f = (Map) gaVar.a(k, 5, false);
        if (l == null) {
            l = new HashMap();
            byte[] bArr = new byte[1];
            bArr[0] = (byte) 0;
            l.put("", bArr);
        }
        this.g = (Map) gaVar.a(l, 6, false);
    }

    public final void a(gb gbVar) {
        gbVar.a(this.d, 0);
        gbVar.a(this.e, 1);
        gbVar.a(this.a, 2);
        if (this.b != null) {
            gbVar.a(this.b, 3);
        }
        if (this.c != null) {
            gbVar.a(this.c, 4);
        }
        if (this.f != null) {
            gbVar.a(this.f, 5);
        }
        if (this.g != null) {
            gbVar.a(this.g, 6);
        }
    }
}
