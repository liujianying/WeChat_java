package com.tencent.mm.plugin.appbrand.game;

class d$2 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ String fwv;
    final /* synthetic */ d fzU;

    d$2(d dVar, int i, String str) {
        this.fzU = dVar;
        this.doP = i;
        this.fwv = str;
    }

    public final void run() {
        d.a(this.fzU, this.doP, this.fwv);
    }
}
