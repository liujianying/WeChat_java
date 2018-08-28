package com.tencent.mm.plugin.game.gamewebview.ui;

class h$3 implements Runnable {
    final /* synthetic */ String gdc;
    final /* synthetic */ h jKm;

    public h$3(h hVar, String str) {
        this.jKm = hVar;
        this.gdc = str;
    }

    public final void run() {
        if (h.a(this.jKm) != null) {
            this.jKm.gcR = this.gdc;
            this.jKm.gcQ.b(h.a(this.jKm), new 1(this), null);
            this.jKm.gcQ.bEo();
        }
    }
}
