package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.a.tc.a;

public class tz {
    private static b d;
    private sl a;
    private sf b;
    private si c;

    public interface d {
        void a(qs qsVar);

        void b(qs qsVar);
    }

    public interface e {
        void a(qw qwVar);
    }

    public interface f {
        void a();
    }

    public tz(sl slVar) {
        this.a = slVar;
        this.b = slVar.e();
        this.c = slVar.b();
    }

    public static void a(b bVar) {
        d = bVar;
    }

    private void b(tr trVar, long j, tt ttVar) {
        if (!this.a.f().k() || j < 0) {
            trVar.a().a(false);
        }
        trVar.a().a(ttVar);
        trVar.a().a(j);
        this.a.c().a(trVar.a());
    }

    public static b n() {
        return d;
    }

    public qt a(qu quVar) {
        return new qt(this.b.a(quVar));
    }

    public qy a(qz qzVar) {
        return new qy(this.b.a(qzVar));
    }

    public ra a(rb rbVar) {
        return new ra(this.b.a(rbVar));
    }

    public rc a(rd rdVar) {
        return new rc(this.b.a(rdVar));
    }

    public final void a() {
        this.b.a();
        this.a.a(false, false);
    }

    public void a(double d, double d2) {
        a(new qw(c().b() - (d / 2.0d), c().c() + (d2 / 2.0d)), new qw(c().b() + (d / 2.0d), c().c() - (d2 / 2.0d)));
    }

    public void a(float f, float f2) {
        b(ts.a(f, f2), 1000, null);
    }

    public void a(float f, float f2, long j, tt ttVar) {
        b(ts.a(f, f2), j, ttVar);
    }

    public void a(int i) {
        b(ts.a((float) i), 0, null);
    }

    public void a(int i, int i2) {
        b(ts.a(1.0f, new Point(i, i2)), 1000, null);
    }

    public void a(qw qwVar) {
        b(ts.a(qwVar), 1000, null);
    }

    public void a(qw qwVar, long j, tt ttVar) {
        b(ts.a(qwVar), j, ttVar);
    }

    public void a(qw qwVar, qw qwVar2) {
        this.a.c().a(ts.a(new qx$a().a(qwVar).a(qwVar2).a(), 10).a());
    }

    public void a(qw qwVar, Runnable runnable) {
        b(ts.a(qwVar), 1000, new 1(this, runnable));
    }

    public void a(tr trVar) {
        if (trVar != null) {
            rw a = trVar.a();
            if (a != null) {
                a.a(false);
                this.a.c().a(a);
            }
        }
    }

    public void a(tr trVar, long j, tt ttVar) {
        if (j < 0) {
            j = 0;
        }
        b(trVar, j, ttVar);
    }

    public void a(a aVar) {
        this.a.h().a(aVar);
    }

    public void a(c cVar) {
        this.a.h().a(cVar);
    }

    public void a(d dVar) {
        this.a.h().a(dVar);
    }

    public void a(e eVar) {
        this.a.h().a(eVar);
    }

    public void a(f fVar) {
        this.a.c().a(fVar);
    }

    public void a(g gVar) {
        this.a.h().a(gVar);
    }

    public void a(h hVar) {
        this.a.h().a(hVar);
    }

    public void a(i iVar) {
        this.a.h().a(iVar);
    }

    public void a(j jVar) {
        this.a.a(jVar);
    }

    public void a(j jVar, Rect rect) {
        this.a.a(jVar, rect);
    }

    public void a(boolean z) {
        if (z) {
            this.a.a(2);
        } else {
            this.a.a(1);
        }
    }

    public void b(int i, int i2) {
        b(ts.a(-1.0f, new Point(i, i2)), 1000, null);
    }

    public void b(qw qwVar) {
        b(ts.a(qwVar, (float) d()), 0, null);
    }

    public void b(tr trVar) {
        b(trVar, 1000, null);
    }

    public void b(boolean z) {
        this.a.i().a(z);
    }

    public boolean b() {
        return te.a().a(a.b) && te.a().a(a.a) && te.a().a(a.c);
    }

    public qw c() {
        return this.c.d().b();
    }

    public void c(boolean z) {
        if (this.a != null) {
            this.a.g(z);
        }
    }

    public int d() {
        return (int) this.c.d().c();
    }

    public int e() {
        return this.c.i().a();
    }

    public int f() {
        return this.c.j().a();
    }

    public final String g() {
        return "1.3.1.e70cce6";
    }

    public final boolean h() {
        return sl.p();
    }

    public final boolean i() {
        return this.a.l() == 2;
    }

    public void j() {
        b(ts.a(), 1000, null);
    }

    public void k() {
        b(ts.b(), 1000, null);
    }

    public void l() {
        this.a.d().g();
    }

    public boolean m() {
        return this.a.i().a();
    }

    public boolean o() {
        return this.a == null ? false : this.a.r();
    }
}
