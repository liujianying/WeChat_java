package com.tencent.tencentmap.mapsdk.a;

public final class os {
    private ot a = null;
    private String b = "";
    private ns c = null;

    public os(ot otVar, ns nsVar, String str) {
        this.b = str;
        this.a = otVar;
        this.c = nsVar;
    }

    public final boolean a(ox oxVar) {
        return ki.c(c(), oxVar) < d();
    }

    public final void a() {
        if (this.c != null) {
            this.c.a(this.b);
        }
    }

    public final String b() {
        return this.b;
    }

    public final void b(ox oxVar) {
        if (this.c != null) {
            this.c.a(this.b, oxVar);
            this.a.a(oxVar);
        }
    }

    public final ox c() {
        return new ox(this.a.a().a, this.a.a().b);
    }

    public final void a(double d) {
        if (d >= 0.0d && this.c != null) {
            this.c.a(this.b, d);
            this.a.a(d);
        }
    }

    public final double d() {
        return this.a.b();
    }

    public final void a(float f) {
        if (f >= 0.0f) {
            this.c.a(this.b, f);
            this.a.a(f);
        }
    }

    public final float e() {
        return this.a.c();
    }

    public final void a(int i) {
        this.c.b(this.b, i);
        this.a.a(i);
    }

    public final int f() {
        return this.a.d();
    }

    public final void b(int i) {
        this.c.a(this.b, i);
        this.a.b(i);
    }

    public final int g() {
        return this.a.e();
    }

    public final void c(int i) {
        this.c.b(this.b, (float) i);
        this.a.c(i);
    }

    public final float h() {
        return (float) this.a.f();
    }

    public final void a(boolean z) {
        this.c.a(this.b, z);
        this.a.a(z);
    }

    public final boolean i() {
        return this.a.g();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof os)) {
            return false;
        }
        return this.b.equals(((os) obj).b);
    }

    public final int hashCode() {
        return 0;
    }
}
