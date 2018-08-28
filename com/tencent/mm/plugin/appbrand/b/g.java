package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.plugin.appbrand.report.d;

abstract class g extends d {
    private final h fjL;

    g(h hVar) {
        this.fjL = hVar;
    }

    public void enter() {
        super.enter();
        this.fjL.a(this);
    }
}
