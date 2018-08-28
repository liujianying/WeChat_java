package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.mm.plugin.appbrand.q.c;

class f$2 implements Runnable {
    final /* synthetic */ f geo;

    f$2(f fVar) {
        this.geo = fVar;
    }

    public final void run() {
        f.d(this.geo).executeVoidScript(c.vM("bootstrap_j2v8.js"));
    }
}
