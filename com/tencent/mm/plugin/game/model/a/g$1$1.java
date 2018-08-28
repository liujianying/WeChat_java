package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.plugin.game.model.a.g.1;

class g$1$1 implements Runnable {
    final /* synthetic */ 1 jOQ;

    g$1$1(1 1) {
        this.jOQ = 1;
    }

    public final void run() {
        g.cancelDownload(this.jOQ.jOO.field_appId);
        this.jOQ.jOP.fv(false);
    }
}
