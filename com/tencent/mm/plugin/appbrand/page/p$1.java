package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.x;

class p$1 implements Runnable {
    final /* synthetic */ p gnH;

    p$1(p pVar) {
        this.gnH = pVar;
    }

    public final void run() {
        x.i("MicroMsg.AppBrandPageView", "[showErrorPageViewRunnable]showErrorPageView");
        this.gnH.alQ();
    }
}
