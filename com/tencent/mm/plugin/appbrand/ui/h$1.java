package com.tencent.mm.plugin.appbrand.ui;

class h$1 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ String etb;
    final /* synthetic */ h gwP;

    h$1(h hVar, int i, String str) {
        this.gwP = hVar;
        this.bpX = i;
        this.etb = str;
    }

    public final void run() {
        h.a(this.gwP, this.bpX, this.etb);
    }
}
