package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.x;

class n$9 implements Runnable {
    final /* synthetic */ n gmP;

    n$9(n nVar) {
        this.gmP = nVar;
    }

    public final void run() {
        if (n.c(this.gmP) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            p pVar = new p();
            pVar.a(this.gmP.getContext(), n.d(this.gmP));
            pVar.hide();
            this.gmP.addView(pVar.getContentView(), 0);
            n.a(this.gmP, pVar);
            x.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }
}
