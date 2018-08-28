package com.tencent.tencentmap.mapsdk.a;

public final class rj {
    private final qx a;
    private final int b;
    private final qw c;
    private final qw d;
    private final qw e;
    private final qw f;

    protected rj(int i, qw qwVar, qw qwVar2, qw qwVar3, qw qwVar4, qx qxVar) {
        this.b = i;
        this.d = qwVar;
        this.c = qwVar2;
        this.f = qwVar3;
        this.e = qwVar4;
        this.a = qxVar;
    }

    public rj(qw qwVar, qw qwVar2, qw qwVar3, qw qwVar4, qx qxVar) {
        this(1, qwVar, qwVar2, qwVar3, qwVar4, qxVar);
    }

    public final qw a() {
        return this.d;
    }

    public final qw b() {
        return this.c;
    }

    public final qw c() {
        return this.f;
    }

    public final qw d() {
        return this.e;
    }

    public final qx e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rj)) {
            return false;
        }
        rj rjVar = (rj) obj;
        return a().equals(rjVar.a()) && b().equals(rjVar.b()) && c().equals(rjVar.c()) && d().equals(rjVar.d()) && e().equals(rjVar.e());
    }

    public final int hashCode() {
        return sz.a(new Object[]{a(), b(), c(), d(), e()});
    }

    public final String toString() {
        return sz.a(new String[]{sz.a("nearLeft", a()), sz.a("nearRight", b()), sz.a("farLeft", c()), sz.a("farRight", d()), sz.a("latLngBounds", e())});
    }
}
