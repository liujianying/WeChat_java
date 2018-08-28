package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.p.g;

class p$9 implements Runnable {
    final /* synthetic */ p gnH;

    p$9(p pVar) {
        this.gnH = pVar;
    }

    public final void run() {
        for (g onReady : this.gnH.gnh) {
            onReady.onReady();
        }
    }
}
