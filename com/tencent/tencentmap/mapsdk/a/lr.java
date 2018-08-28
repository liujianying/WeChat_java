package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.lo.a;

public class lr implements nj {
    private lo a;

    public lr(lo loVar) {
        this.a = loVar;
    }

    public String a(int i, int i2, int i3) {
        if (this.a == null) {
            return null;
        }
        a c = this.a.c();
        String d = c.d();
        if (d == null) {
            return null;
        }
        if (c.a().equals("taiwanmap")) {
            i2 = (int) ((Math.pow(2.0d, (double) i3) - 1.0d) - ((double) i2));
            i3--;
        }
        return d.replace("{x}", String.valueOf(i)).replace("{y}", String.valueOf(i2)).replace("{z}", String.valueOf(i3));
    }
}
