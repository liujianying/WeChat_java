package com.tencent.tencentmap.mapsdk.a;

public final class ry extends rw {
    private qs d;

    public final void a(qs qsVar) {
        this.d = qsVar;
    }

    public final void a(sl slVar) {
        sh c = slVar.c();
        if (this.a) {
            c.a(rv.a(this.d.b()), this.b, this.c);
        } else {
            c.b(rv.a(this.d.b()));
        }
        if (this.d.c() > 0.0f) {
            c.b((double) this.d.c(), false, this.c);
        }
    }

    public final boolean a() {
        return false;
    }
}
