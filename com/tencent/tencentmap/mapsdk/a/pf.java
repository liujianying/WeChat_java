package com.tencent.tencentmap.mapsdk.a;

import java.util.List;

public final class pf implements ou {
    private pg a = null;
    private String b = "";
    private na c = null;

    public pf(pg pgVar, na naVar, String str) {
        this.b = str;
        this.a = pgVar;
        this.c = naVar;
    }

    public final void b() {
        if (this.c != null) {
            this.c.a(this.b);
        }
    }

    public final String c() {
        return this.b;
    }

    public final void a(List<ox> list) {
        this.c.a(this.b, list);
        this.a.a(list);
    }

    public final List<ox> d() {
        return this.a.d();
    }

    public final void a(float f) {
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.c.a(this.b, f);
        this.a.a(f);
    }

    public final float e() {
        return this.a.e();
    }

    public final void a(int i) {
        this.c.a(this.b, i);
        this.a.a(i);
    }

    public final int f() {
        return this.a.f();
    }

    public final void b(int i) {
        this.c.b(this.b, (float) Math.max(0, i));
        this.a.c(Math.max(0, i));
    }

    public final int g() {
        return this.a.h();
    }

    public final void a(boolean z) {
        this.c.a(this.b, z);
        this.a.a(z);
    }

    public final boolean h() {
        return this.a.i();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pf)) {
            return false;
        }
        return this.b.equals(((pf) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final List<iw> a() {
        return this.c.b(this.b);
    }

    public final boolean i() {
        if (this.a != null) {
            return this.a.t();
        }
        return false;
    }
}
