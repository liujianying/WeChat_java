package com.tencent.mm.plugin.appbrand.page;

class p$14 implements Runnable {
    final /* synthetic */ p gnH;
    final /* synthetic */ double gnJ;

    p$14(p pVar, double d) {
        this.gnH = pVar;
        this.gnJ = d;
    }

    public final void run() {
        this.gnH.gnn.setBackgroundAlpha(this.gnJ);
    }
}
