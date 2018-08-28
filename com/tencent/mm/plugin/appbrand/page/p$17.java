package com.tencent.mm.plugin.appbrand.page;

class p$17 implements Runnable {
    final /* synthetic */ String dEt;
    final /* synthetic */ p gnH;

    p$17(p pVar, String str) {
        this.gnH = pVar;
        this.dEt = str;
    }

    public final void run() {
        this.gnH.gnn.setMainTitle(this.dEt);
    }
}
