package com.tencent.mm.plugin.game.gamewebview.ui;

class c$5 implements Runnable {
    final /* synthetic */ boolean gmW;
    final /* synthetic */ boolean gmc;
    final /* synthetic */ c jIM;
    final /* synthetic */ b jIO;

    c$5(c cVar, boolean z, b bVar, boolean z2) {
        this.jIM = cVar;
        this.gmc = z;
        this.jIO = bVar;
        this.gmW = z2;
    }

    public final void run() {
        if (this.gmc) {
            this.jIO.fo(true);
            this.jIO.hide();
        }
        if (this.gmW) {
            c.b(this.jIM, this.jIO);
        }
    }
}
