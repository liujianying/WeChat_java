package com.tencent.mm.plugin.appbrand.canvas;

class d$2 implements Runnable {
    final /* synthetic */ d fna;

    d$2(d dVar) {
        this.fna = dVar;
    }

    public final void run() {
        boolean z = this.fna.fmT;
        this.fna.fmT = false;
        if (z && this.fna.fmN) {
            this.fna.fmR.adk();
        }
    }
}
