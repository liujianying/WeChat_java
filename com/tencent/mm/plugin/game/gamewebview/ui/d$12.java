package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.a.a;

class d$12 implements Runnable {
    final /* synthetic */ d jJO;
    final /* synthetic */ int jJP;

    d$12(d dVar, int i) {
        this.jJO = dVar;
        this.jJP = i;
    }

    public final void run() {
        a.a(this.jJO, this.jJP);
    }
}
