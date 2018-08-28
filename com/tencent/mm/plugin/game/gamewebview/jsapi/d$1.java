package com.tencent.mm.plugin.game.gamewebview.jsapi;

class d$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ String fEQ;
    final /* synthetic */ String fwv;
    final /* synthetic */ d jGz;

    d$1(d dVar, String str, String str2, int i) {
        this.jGz = dVar;
        this.fEQ = str;
        this.fwv = str2;
        this.doP = i;
    }

    public final void run() {
        this.jGz.w(this.fEQ, this.fwv, this.doP);
    }
}
