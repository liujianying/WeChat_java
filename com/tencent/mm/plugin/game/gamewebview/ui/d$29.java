package com.tencent.mm.plugin.game.gamewebview.ui;

class d$29 implements Runnable {
    final /* synthetic */ boolean jIP;
    final /* synthetic */ d jJO;

    d$29(d dVar, boolean z) {
        this.jJO = dVar;
        this.jIP = z;
    }

    public final void run() {
        b M = d.M(this.jJO);
        boolean z = this.jIP;
        c cVar = M.jIE;
        if (cVar.jII.peek() == M) {
            cVar.fp(z);
            return;
        }
        cVar.jII.remove(M);
        cVar.a(M);
    }
}
