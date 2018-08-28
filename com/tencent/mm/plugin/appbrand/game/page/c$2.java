package com.tencent.mm.plugin.appbrand.game.page;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;

class c$2 implements Runnable {
    final /* synthetic */ c fCE;

    c$2(c cVar) {
        this.fCE = cVar;
    }

    public final void run() {
        e.a(this.fCE.getAppId(), c.fcg);
        this.fCE.getRuntime().close();
    }
}
