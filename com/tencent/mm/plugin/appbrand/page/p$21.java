package com.tencent.mm.plugin.appbrand.page;

class p$21 implements Runnable {
    final /* synthetic */ p gnH;
    final /* synthetic */ boolean gnL;

    p$21(p pVar, boolean z) {
        this.gnH = pVar;
        this.gnL = z;
    }

    public final void run() {
        this.gnH.gnn.setLoadingIconVisibility(this.gnL);
    }
}
