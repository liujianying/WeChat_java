package com.tencent.mm.plugin.appbrand.page;

class p$25 implements Runnable {
    final /* synthetic */ p gnH;
    final /* synthetic */ boolean gnO;

    p$25(p pVar, boolean z) {
        this.gnH = pVar;
        this.gnO = z;
    }

    public final void run() {
        this.gnH.gnt.setPullDownEnabled(this.gnO);
        this.gnH.gnt.cE(this.gnO);
    }
}
