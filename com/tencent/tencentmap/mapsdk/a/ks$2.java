package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;

class ks$2 implements hz {
    final /* synthetic */ ks a;

    ks$2(ks ksVar) {
        this.a = ksVar;
    }

    public boolean a(float f, float f2) {
        if (ks.m(this.a)) {
            if (ks.l(this.a) != null && ks.m(this.a)) {
                ks.l(this.a).a(f, f2);
            }
            if (ks.q(this.a) != null) {
                ks.q(this.a).a(f, f2);
            }
        }
        return false;
    }

    public boolean b(float f, float f2) {
        if (ks.m(this.a)) {
            if (!ks.a(this.a, f, f2)) {
                ks.b(this.a, f, f2);
            }
            if (ks.l(this.a) != null && ks.m(this.a)) {
                ks.l(this.a).b(f, f2);
            }
            if (ks.q(this.a) != null && ks.m(this.a)) {
                ks.q(this.a).b(f, f2);
            }
        }
        return false;
    }

    public boolean c(float f, float f2) {
        if (ks.m(this.a)) {
            if (ks.l(this.a) != null) {
                ks.l(this.a).c(f, f2);
            }
            if (ks.q(this.a) != null) {
                ks.q(this.a).c(f, f2);
            }
        }
        return false;
    }

    public boolean d(float f, float f2) {
        if (ks.m(this.a)) {
            if (ks.l(this.a) != null) {
                ks.l(this.a).d(f, f2);
            }
            if (ks.q(this.a) != null) {
                ks.q(this.a).d(f, f2);
            }
        }
        return false;
    }

    public boolean e(float f, float f2) {
        if (ks.m(this.a)) {
            ks.c(this.a, f, f2);
            if (ks.l(this.a) != null) {
                ks.l(this.a).e(f, f2);
            }
            if (ks.q(this.a) != null) {
                ks.q(this.a).e(f, f2);
            }
        }
        return false;
    }

    public boolean f(float f, float f2) {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).i(f, f2);
        }
        return false;
    }

    public boolean g(float f, float f2) {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).j(f, f2);
        }
        return false;
    }

    public boolean h(float f, float f2) {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).k(f, f2);
        }
        return false;
    }

    public boolean a() {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).a();
        }
        return false;
    }

    public boolean b() {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).b();
        }
        return false;
    }

    public boolean a(float f) {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).a(f);
        }
        return false;
    }

    public boolean c() {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).c();
        }
        return false;
    }

    public boolean a(PointF pointF, PointF pointF2, float f) {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).a(pointF, pointF2, f);
        }
        return false;
    }

    public boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).a(pointF, pointF2, d, d2);
        }
        return false;
    }

    public boolean i(float f, float f2) {
        if (ks.m(this.a)) {
            ks.r(this.a);
            if (this.a.f == null || !this.a.f.a(f, f2)) {
                if (ks.l(this.a) != null) {
                    ks.l(this.a).f(f, f2);
                }
                if (ks.q(this.a) != null) {
                    ks.q(this.a).f(f, f2);
                }
            } else if (this.a.f.g(true)) {
                this.a.f();
            }
        }
        return false;
    }

    public boolean j(float f, float f2) {
        if (ks.m(this.a)) {
            ks.a(this.a, ks.k(this.a) > 0 ? ks.s(this.a) : 0);
            if (ks.t(this.a) && ks.j(this.a) && ks.k(this.a) == 0) {
                ks.b(this.a, false);
                or i = ks.i(this.a);
                if (i != null) {
                    this.a.n.b(i);
                }
            }
            ks.d(this.a, f, f2);
            if (this.a.f == null || !this.a.f.g(false)) {
                if (ks.l(this.a) != null) {
                    ks.l(this.a).g(f, f2);
                }
                if (ks.q(this.a) != null) {
                    ks.q(this.a).g(f, f2);
                }
            } else {
                this.a.f();
            }
        }
        return false;
    }

    public void d() {
    }

    public boolean k(float f, float f2) {
        if (ks.m(this.a) && ks.q(this.a) != null) {
            ks.q(this.a).h(f, f2);
        }
        return false;
    }
}
