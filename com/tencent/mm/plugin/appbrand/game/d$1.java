package com.tencent.mm.plugin.appbrand.game;

class d$1 implements Runnable {
    final /* synthetic */ d fzU;

    d$1(d dVar) {
        this.fzU = dVar;
    }

    public final void run() {
        d.a(this.fzU, System.currentTimeMillis());
        d.a(this.fzU);
        if (d.b(this.fzU) != null) {
            d.d(this.fzU).fcJ.o(10, System.currentTimeMillis() - d.c(this.fzU));
        }
        d.e(this.fzU);
        if (!d.f(this.fzU)) {
            d.g(this.fzU);
        }
        d.h(this.fzU);
    }
}
