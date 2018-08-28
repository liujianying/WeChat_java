package com.tencent.tencentmap.mapsdk.a;

class gr$a extends gr {
    gk d;

    public gr$a(int i, double... dArr) {
        super(i, null);
        a(dArr);
    }

    public void a(double... dArr) {
        super.a(dArr);
        this.d = (gk) this.c;
    }

    /* renamed from: c */
    public gr$a clone() {
        gr$a gr_a = (gr$a) super.a();
        gr_a.d = (gk) gr_a.c;
        return gr_a;
    }
}
