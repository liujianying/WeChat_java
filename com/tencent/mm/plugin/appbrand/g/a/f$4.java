package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.mm.plugin.appbrand.g.a.f.a;

class f$4 implements Runnable {
    final /* synthetic */ String fwG;
    final /* synthetic */ f geo;
    final /* synthetic */ a gep = null;
    final /* synthetic */ String geq;

    f$4(f fVar, String str, String str2) {
        this.geo = fVar;
        this.fwG = str;
        this.geq = str2;
    }

    public final void run() {
        if (this.gep != null) {
            f.d(this.geo).executeScript(this.fwG, this.geq, 0).toString();
        } else {
            f.d(this.geo).executeVoidScript(this.fwG, this.geq, 0);
        }
    }
}
