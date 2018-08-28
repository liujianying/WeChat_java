package com.tencent.mm.plugin.game.gamewebview.ui;

class c$4 implements Runnable {
    final /* synthetic */ c jIM;
    final /* synthetic */ boolean jIP;

    c$4(c cVar, boolean z) {
        this.jIM = cVar;
        this.jIP = z;
    }

    public final void run() {
        b bVar = (b) c.a(this.jIM).peek();
        c.a(this.jIM, bVar, (b) c.a(this.jIM).pop(), this.jIP);
    }
}
