package com.tencent.mm.plugin.game.gamewebview.ui;

class d$17 implements Runnable {
    final /* synthetic */ String fwv;
    final /* synthetic */ String fzV;
    final /* synthetic */ d jJO;

    d$17(d dVar, String str, String str2) {
        this.jJO = dVar;
        this.fzV = str;
        this.fwv = str2;
    }

    public final void run() {
        if (d.n(this.jJO) != null) {
            d.n(this.jJO).cY(this.fzV, this.fwv);
        }
    }
}
