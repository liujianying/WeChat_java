package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;

class b$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ c fQE;
    final /* synthetic */ Integer fQF;
    final /* synthetic */ b fQG;

    b$1(b bVar, c cVar, Integer num, int i) {
        this.fQG = bVar;
        this.fQE = cVar;
        this.fQF = num;
        this.doP = i;
    }

    public final void run() {
        if (this.fQE.isRunning()) {
            c cVar = this.fQE;
            this.fQE.E(this.doP, this.fQG.f(m.a(cVar instanceof p ? (p) cVar : a.d((l) cVar), this.fQF) ? "ok" : "fail:input not exists", null));
        }
    }
}
