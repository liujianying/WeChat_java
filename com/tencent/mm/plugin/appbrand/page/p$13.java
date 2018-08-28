package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.page.p.e;

class p$13 implements Runnable {
    final /* synthetic */ p gnH;

    p$13(p pVar) {
        this.gnH = pVar;
    }

    public final void run() {
        for (e onDestroy : this.gnH.gnk) {
            onDestroy.onDestroy();
        }
    }
}
