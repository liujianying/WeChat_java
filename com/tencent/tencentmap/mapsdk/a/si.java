package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;

public final class si {
    private static final rt a = new rt(new ru(-2.003750834E7d, -2.003750834E7d), new ru(2.003750834E7d, 2.003750834E7d));
    private sl b;
    private sh c;
    private rs d;
    private rs e;
    private boolean f = false;
    private rt g;
    private double h = 0.0d;
    private double i = 0.0d;

    public si(sl slVar) {
        this.b = slVar;
    }

    private double a(double d) {
        return this.c.d().d() * Math.cos(0.017453292519943295d * d);
    }

    private double a(boolean z) {
        qx c = c();
        return z ? Math.abs(c.c().c() - c.b().c()) : Math.abs(c.c().b() - c.b().b());
    }

    private ru[] k() {
        int width = this.c.getWidth();
        ru a = rv.a(new PointF(0.0f, (float) this.c.getHeight()), this.c.b(), this.c.a(), this.c.d());
        ru a2 = rv.a(new PointF((float) width, 0.0f), this.c.b(), this.c.a(), this.c.d());
        return new ru[]{a, a2};
    }

    public final float a(double d, double d2) {
        return (float) (d2 / a(d));
    }

    public final float a(float f) {
        return (float) (((double) f) / a(0.0d));
    }

    public final PointF a(qw qwVar) {
        ru b = this.c.b();
        PointF a = this.c.a();
        rs d = this.c.d();
        ru a2 = rv.a(qwVar);
        double b2 = (a2.b() - b.b()) / d.d();
        double a3 = (a2.a() - b.a()) / d.d();
        PointF pointF = new PointF();
        pointF.x = (float) (b2 + ((double) a.x));
        pointF.y = (float) (((double) a.y) - a3);
        return pointF;
    }

    public final qw a(int i, int i2) {
        return rv.a(rv.a(new PointF((float) i, (float) i2), this.c.b(), this.c.a(), this.c.d()));
    }

    public final rs a(rs rsVar) {
        rs rsVar2;
        Object obj = (this.b.f().a() < 3 || this.b.f().b() <= 1.0f) ? null : 1;
        if (rsVar.c() < (obj != null ? Math.log(1.3d) / Math.log(2.0d) : 0.0d) + ((double) this.e.a())) {
            rsVar2 = new rs(this.e.c());
            if (obj != null) {
                rsVar2.a(1.3d);
            }
        } else {
            rsVar2 = rsVar;
        }
        if (rsVar.c() > (obj != null ? Math.log(1.3d) / Math.log(2.0d) : 0.0d) + this.d.c()) {
            rsVar2 = new rs(this.d.c());
            if (obj != null) {
                rsVar2.a(1.3d);
            }
        }
        return rsVar2;
    }

    public final void a() {
        this.g = a;
        this.d = new rs(19.0d);
        this.e = new rs((double) rs.a);
        this.c = this.b.c();
    }

    protected final void a(int i) {
        this.h = 0.0d;
    }

    public final void a(ru ruVar) {
        double d = 0.0d;
        if (this.g != null) {
            ru[] k = k();
            ru a = this.g.a();
            ru b = this.g.b();
            double a2 = a.a() > k[0].a() ? a.a() - k[0].a() : 0.0d;
            if (a.b() > k[0].b()) {
                d = a.b() - k[0].b();
            }
            if (b.a() < k[1].a()) {
                a2 = b.a() - k[1].a();
            }
            if (b.b() < k[1].b()) {
                d = b.b() - k[1].b();
            }
            ruVar.a(a2 + ruVar.a());
            ruVar.b(ruVar.b() + d);
        }
    }

    protected final void b(double d, double d2) {
        if (d > 0.0d && d2 > 0.0d) {
            double a = a(true);
            double a2 = a(false);
            if (a == 0.0d && a2 == 0.0d) {
                this.h = d;
                this.i = d2;
                return;
            }
            a = Math.max(d / a2, d2 / a);
            rs d3 = this.c.d();
            d3.a(a * d3.b());
            a(d3);
            this.b.a(false, false);
        }
    }

    protected final void b(int i) {
        this.i = 0.0d;
    }

    public final ru[] b() {
        int i = 0;
        r1 = new ru[8];
        r2 = new PointF[8];
        float width = (float) this.c.getWidth();
        float height = (float) this.c.getHeight();
        r2[0] = new PointF(0.0f, 0.0f);
        r2[1] = new PointF(width / 2.0f, 0.0f);
        r2[2] = new PointF(width, 0.0f);
        r2[3] = new PointF(width, height / 2.0f);
        r2[4] = new PointF(width, height);
        r2[5] = new PointF(width / 2.0f, height);
        r2[6] = new PointF(0.0f, height);
        r2[7] = new PointF(0.0f, height / 2.0f);
        while (i < 8) {
            r1[i] = rv.a(r2[i], this.c.b(), this.c.a(), this.c.d());
            i++;
        }
        return r1;
    }

    public final qx c() {
        ru[] k = k();
        return new qx(rv.a(k[0]), rv.a(k[1]));
    }

    public final void c(int i) {
        if (this.f && ((double) i) <= this.e.c()) {
            i = this.e.a();
        }
        if (i <= rs.a) {
            i = rs.a;
        }
        if (((double) i) >= this.d.c()) {
            i = this.d.a();
        }
        this.e.b((double) i);
        if (this.c.d().c() <= this.e.c()) {
            this.c.b(this.e.c(), true, null);
        }
    }

    public final qs d() {
        return qs.a().a(rv.a(this.c.b())).a((float) this.c.d().a()).a();
    }

    public final double e() {
        double d = 1.0d;
        if (this.c.d().a() >= 7) {
            d = 1.0d - Math.abs(this.c.b().a() / 2.003750834E7d);
            if (d < 0.1d) {
                d = 0.1d;
            }
        }
        return d * this.c.d().d();
    }

    public final float f() {
        int width = this.c.getWidth();
        return (float) (rv.a(a(0, 0), a(width, 0)) / ((double) width));
    }

    protected final double g() {
        return this.h;
    }

    protected final double h() {
        return this.i;
    }

    public final rs i() {
        return this.d;
    }

    public final rs j() {
        return this.e;
    }
}
