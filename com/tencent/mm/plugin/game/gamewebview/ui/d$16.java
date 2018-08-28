package com.tencent.mm.plugin.game.gamewebview.ui;

class d$16 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ d jJO;
    final /* synthetic */ String jJS;

    d$16(d dVar, int i, String str) {
        this.jJO = dVar;
        this.doP = i;
        this.jJS = str;
    }

    public final void run() {
        if (d.n(this.jJO) != null) {
            d.n(this.jJO).E(this.doP, this.jJS);
        }
    }
}
