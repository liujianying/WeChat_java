package com.tencent.tencentmap.mapsdk.a;

public final class rm extends rl {
    private ru d;
    private ru e;
    private double f;
    private double g;

    public rm(sl slVar, ru ruVar, long j, tt ttVar) {
        super(slVar, j, ttVar);
        this.e = ruVar;
    }

    protected final void a(float f) {
        double d = this.g * ((double) f);
        this.d.b((this.f * ((double) f)) + this.d.b());
        this.d.a(d + this.d.a());
        this.b.b(this.d);
    }

    protected final void c() {
        this.d = this.b.b();
        this.f = this.e.b() - this.d.b();
        this.g = this.e.a() - this.d.a();
    }

    protected final void d() {
        this.b.b(this.e);
    }
}
