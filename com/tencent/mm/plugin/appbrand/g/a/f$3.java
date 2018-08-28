package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.mm.plugin.appbrand.g.a.f.a;

class f$3 implements Runnable {
    final /* synthetic */ String fwG;
    final /* synthetic */ f geo;
    final /* synthetic */ a gep = null;

    f$3(f fVar, String str) {
        this.geo = fVar;
        this.fwG = str;
    }

    public final void run() {
        if (this.gep != null) {
            f.d(this.geo).executeScript(this.fwG).toString();
        } else {
            f.d(this.geo).executeVoidScript(this.fwG);
        }
    }
}
