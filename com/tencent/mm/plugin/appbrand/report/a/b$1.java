package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.page.p;

class b$1 implements Runnable {
    final /* synthetic */ p gra;
    final /* synthetic */ p grb;
    final /* synthetic */ b grc;

    b$1(b bVar, p pVar, p pVar2) {
        this.grc = bVar;
        this.gra = pVar;
        this.grb = pVar2;
    }

    public final void run() {
        this.grc.a(this.gra, this.grb);
    }
}
