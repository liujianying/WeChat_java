package com.tencent.mm.plugin.appbrand.game;

class d$3 implements Runnable {
    final /* synthetic */ String fwv;
    final /* synthetic */ d fzU;
    final /* synthetic */ String fzV;
    final /* synthetic */ int fzW;

    d$3(d dVar, String str, String str2, int i) {
        this.fzU = dVar;
        this.fzV = str;
        this.fwv = str2;
        this.fzW = i;
    }

    public final void run() {
        d.a(this.fzU, this.fzV, this.fwv, this.fzW);
    }
}
