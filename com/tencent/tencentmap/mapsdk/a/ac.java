package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.location.Location;

public final class ac {
    private static int C = 1;
    private ae A;
    private aa B;
    private final ni$a D;
    private mp a;
    private nv b;
    private nt c;
    private nb d;
    private mz e;
    private mu f;
    private mt g;
    private mo h;
    private ni i;
    private nq j;
    private mw k;
    private nm l;
    private nk m;
    private ab n;
    private nu o;
    private ns p;
    private na q;
    private my r;
    private mr s;
    private ms t;
    private ok u;
    private nh v;
    private np w;
    private mv x;
    private boolean y;
    private mm z;

    public interface n {
    }

    public interface o {
        void a(pf pfVar, ox oxVar);
    }

    protected ac(aa aaVar, Context context, ad adVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = false;
        this.z = null;
        this.B = null;
        this.D = new 1(this);
        kh.b(context);
        kh.a(context);
        this.B = aaVar;
        this.a = new mp(this.B, context, adVar);
        this.z = new mm(this.a, b());
        if (this.v == null) {
            if (this.i == null) {
                this.i = new ni(this.B, b().b());
                this.i.a(this.D);
            }
            this.v = new nh(this.i);
        }
        if (this.l == null) {
            this.l = new nm(context, this.i);
        }
        this.l.b();
        this.l.c();
        g(false);
    }

    protected ac() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = false;
        this.z = null;
        this.B = null;
        this.D = new 1(this);
        this.a = new mp(null, null, null);
        this.z = new mm(this.a, b());
    }

    public static int a() {
        return C;
    }

    final nk b() {
        if (this.m == null) {
            this.m = new nk(this.a);
        }
        return this.m;
    }

    public final mp c() {
        return this.a;
    }

    public final or d() {
        if (this.y) {
            return null;
        }
        if (this.o == null) {
            this.o = new nu(this.a);
        }
        return this.o.b();
    }

    public final float e() {
        if (this.y) {
            return 0.0f;
        }
        if (this.o == null) {
            this.o = new nu(this.a);
        }
        return this.o.c();
    }

    public final float f() {
        if (this.y) {
            return 0.0f;
        }
        if (this.o == null) {
            this.o = new nu(this.a);
        }
        return this.o.d();
    }

    public final void a(x xVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(xVar);
        }
    }

    public final void b(x xVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(xVar, 500, null);
        }
    }

    public final void a(x xVar, a aVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(xVar, 500, aVar);
        }
    }

    public final void a(x xVar, long j, a aVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(xVar, j, aVar);
        }
    }

    public final void g() {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.e();
        }
    }

    public final pf a(pg pgVar) {
        if (this.y) {
            return null;
        }
        if (this.d == null) {
            if (this.m == null) {
                return null;
            }
            this.d = new nb(this.m.b());
        }
        if (this.q == null) {
            this.q = new na(this.d);
        }
        return this.q.a(pgVar);
    }

    public final pd a(pe peVar) {
        if (this.y || peVar == null) {
            return null;
        }
        if (this.e == null) {
            this.e = new mz(this.m.b());
        }
        if (this.r == null) {
            this.r = new my(this.e);
        }
        return this.r.a(peVar);
    }

    public final os a(ot otVar) {
        if (this.y || otVar == null) {
            return null;
        }
        if (this.c == null) {
            this.c = new nt(this.m.b());
        }
        if (this.p == null) {
            this.p = new ns(this.c);
        }
        return this.p.a(otVar);
    }

    public final pa a(pb pbVar) {
        if (this.y || pbVar == null) {
            return null;
        }
        if (this.f == null) {
            if (this.B == null || this.m == null) {
                return null;
            }
            this.f = new mu(this.B, this.m.b());
        }
        if (this.s == null) {
            this.s = new mr(this.f);
        }
        return this.s.a(pbVar, this.s);
    }

    public final void h() {
        if (this.q != null) {
            this.q.b();
        }
        if (this.r != null) {
            this.r.b();
        }
        if (this.p != null) {
            this.p.b();
        }
        if (this.s != null) {
            this.s.b();
        }
        if (this.w != null) {
            this.w.b();
        }
    }

    public final boolean i() {
        if (this.y) {
            return false;
        }
        if (this.o == null) {
            this.o = new nu(this.a);
        }
        return this.o.f();
    }

    public final void a(boolean z) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(z);
        }
    }

    public final void b(boolean z) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.b(z);
        }
    }

    public final boolean j() {
        if (this.y) {
            return false;
        }
        w();
        return this.u.e();
    }

    private void w() {
        if (this.o == null) {
            this.o = new nu(this.a);
        }
        if (this.s == null) {
            if (this.f == null) {
                this.f = new mu(this.B, this.m.b());
            }
            this.s = new mr(this.f);
        }
        if (this.c == null) {
            this.c = new nt(this.m.b());
        }
        if (this.p == null) {
            this.p = new ns(this.c);
        }
        if (this.h == null) {
            this.h = new mo(this.s, this.p, this.o);
        }
        if (this.u == null) {
            this.u = new ok(this.h);
        }
    }

    public final void c(boolean z) {
        if (!this.y) {
            w();
            if (!z) {
                this.u.d();
            } else if (!j()) {
                this.u.c();
            }
        }
    }

    public final Location k() {
        if (this.y) {
            return null;
        }
        w();
        return this.u.b();
    }

    public final ae l() {
        if (this.y) {
            return null;
        }
        if (this.A == null) {
            if (this.v == null) {
                if (this.i == null) {
                    this.i = new ni(this.B, b().b());
                }
                this.v = new nh(this.i);
            }
            this.A = new ae(this.v);
        }
        return this.A;
    }

    public final ab m() {
        if (this.y) {
            return null;
        }
        if (this.n == null) {
            this.n = new ab(this.a);
        }
        return this.n;
    }

    public final void a(c cVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(cVar);
        }
    }

    public final void a(h hVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(hVar);
        }
    }

    public final void a(j jVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(jVar);
        }
    }

    public final void a(i iVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(iVar);
        }
    }

    final void n() {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.g();
        }
    }

    final void o() {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.h();
            if (this.l != null) {
                this.l.b();
            }
        }
    }

    final void p() {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.i();
        }
    }

    final void q() {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.j();
        }
    }

    final void r() {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.k();
            if (this.l != null) {
                this.l.a();
            }
        }
    }

    final void s() {
        if (!this.y) {
            if (this.o != null) {
                this.o.l();
            }
            if (this.l != null) {
                this.l.d();
            }
            y();
            x();
            this.y = true;
        }
    }

    private void x() {
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.h != null) {
            this.h.a();
            this.h = null;
        }
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        if (this.g != null) {
            this.g.a();
            this.g = null;
        }
        if (this.k != null) {
            this.k.a();
        }
    }

    private void y() {
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        if (this.u != null) {
            this.u.a();
            this.u = null;
        }
        if (this.s != null) {
            this.s.a();
            this.s = null;
        }
        if (this.r != null) {
            this.r.a();
            this.r = null;
        }
        if (this.q != null) {
            this.q.a();
            this.q = null;
        }
        if (this.p != null) {
            this.p.a();
            this.p = null;
        }
        if (this.w != null) {
            this.w.a();
            this.w = null;
        }
        if (this.t != null) {
            this.t.a();
            this.t = null;
        }
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
    }

    public final aa t() {
        return this.B;
    }

    public final void a(p pVar, Config config) {
        if (this.o == null) {
            this.o = new nu(this.a);
        }
        this.o.a(pVar, config);
    }

    public final void a(p pVar) {
        a(pVar, Config.ARGB_8888);
    }

    public final void a(float f, float f2, boolean z) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(f, f2, z);
        }
    }

    public final String u() {
        if (this.y) {
            return "";
        }
        if (this.o == null) {
            this.o = new nu(this.a);
        }
        return this.o.m();
    }

    protected final void d(boolean z) {
        if (!this.y && this.a != null) {
            this.a.c(z);
        }
    }

    public final void e(boolean z) {
        if (!this.y && this.a != null) {
            this.a.a(z, false);
        }
    }

    public final void a(l lVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(lVar);
        }
    }

    public final void a(m mVar) {
        if (!this.y) {
            if (this.f == null) {
                this.f = new mu(this.B, this.m.b());
            }
            if (this.s == null) {
                this.s = new mr(this.f);
            }
            this.s.a(mVar);
        }
    }

    public final void a(g gVar) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.a(gVar);
        }
    }

    public final void a(b bVar) {
        if (!this.y) {
            if (this.f == null) {
                this.f = new mu(this.B, this.m.b());
            }
            if (this.s == null) {
                this.s = new mr(this.f);
            }
            this.s.a(bVar);
        }
    }

    private void g(boolean z) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.c(z);
        }
    }

    public final void f(boolean z) {
        if (!this.y) {
            if (this.o == null) {
                this.o = new nu(this.a);
            }
            this.o.d(z);
        }
    }

    public final boolean v() {
        if (this.y) {
            return false;
        }
        if (this.o == null) {
            this.o = new nu(this.a);
        }
        return this.o.n();
    }
}
