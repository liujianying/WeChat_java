package com.tencent.mm.plugin.appbrand;

class h$3 implements Runnable {
    final /* synthetic */ g fdq;
    final /* synthetic */ h fdt;

    h$3(h hVar, g gVar) {
        this.fdt = hVar;
        this.fdq = gVar;
    }

    public final void run() {
        if (this.fdq.aap()) {
            this.fdt.f(this.fdq);
        }
    }
}
