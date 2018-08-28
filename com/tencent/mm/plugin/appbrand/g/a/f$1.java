package com.tencent.mm.plugin.appbrand.g.a;

class f$1 implements Runnable {
    final /* synthetic */ f geo;

    f$1(f fVar) {
        this.geo = fVar;
    }

    public final void run() {
        f.b(this.geo).add(new d().a(this.geo));
        f.b(this.geo).add(new e().a(this.geo));
        f.b(this.geo).add(new c(f.c(this.geo)).a(this.geo));
    }
}
