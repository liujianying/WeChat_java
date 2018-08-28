package com.tencent.tencentmap.mapsdk.a;

public final class rx extends rw {
    private int d;
    private int e;
    private qx f;
    private int g;

    public final void a(int i) {
        this.d = i;
    }

    public final void a(qx qxVar) {
        this.f = qxVar;
    }

    public final void a(sl slVar) {
        sh c = slVar.c();
        this.e = this.e == 0 ? c.getHeight() - (this.g * 2) : this.e - (this.g * 2);
        this.d = this.d == 0 ? c.getWidth() - (this.g * 2) : this.d - (this.g * 2);
        if (this.e != 0 && this.d != 0) {
            qw c2 = this.f.c();
            qw b = this.f.b();
            ru a = rv.a(c2);
            ru a2 = rv.a(b);
            double a3 = a.a() - a2.a();
            double b2 = a.b() - a2.b();
            rs a4 = slVar.b().a(new rs(0, (double) ((((float) this.e) * 1.0f) / ((float) this.d) < ((float) (a3 / b2)) ? (float) ((((double) this.e) * 156543.0339d) / a3) : (float) ((((double) this.d) * 156543.0339d) / b2))));
            ru ruVar = new ru((b2 / 2.0d) + a2.b(), (a3 / 2.0d) + a2.a());
            if (this.a) {
                c.a(ruVar, this.b, this.c);
            } else {
                c.b(ruVar);
            }
            c.b(a4.c(), this.a, this.c);
        }
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void c(int i) {
        this.g = i;
    }
}
