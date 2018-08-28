package com.tencent.tencentmap.mapsdk.a;

public final class rz extends rw {
    private float d;
    private float e;

    public final void a(float f) {
        this.d = f;
    }

    public final void a(sl slVar) {
        sh c = slVar.c();
        if (this.a) {
            c.a((int) (-this.d), (int) (-this.e), this.b, this.c);
        } else {
            c.scrollBy((int) (-this.d), (int) (-this.e));
        }
    }

    public final void b(float f) {
        this.e = f;
    }
}
