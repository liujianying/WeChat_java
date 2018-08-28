package com.tencent.tencentmap.mapsdk.a;

public final class fg extends gc {
    private static fm g;
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public fm f = null;

    public final void a(ga gaVar) {
        this.a = gaVar.a(this.a, 0, false);
        this.b = gaVar.a(this.b, 1, false);
        this.c = gaVar.a(this.c, 2, false);
        this.d = gaVar.a(this.d, 3, false);
        this.e = gaVar.a(this.e, 4, false);
        if (g == null) {
            g = new fm();
        }
        this.f = (fm) gaVar.a(g, 5, false);
    }

    public final void a(gb gbVar) {
        gbVar.a(this.a, 0);
        gbVar.a(this.b, 1);
        gbVar.a(this.c, 2);
        gbVar.a(this.d, 3);
        gbVar.a(this.e, 4);
        if (this.f != null) {
            gbVar.a(this.f, 5);
        }
    }
}
