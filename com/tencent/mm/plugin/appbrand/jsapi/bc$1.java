package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.p;

class bc$1 implements Runnable {
    final /* synthetic */ p fGY;
    final /* synthetic */ long fGZ;
    final /* synthetic */ bc fHa;

    bc$1(bc bcVar, p pVar, long j) {
        this.fHa = bcVar;
        this.fGY = pVar;
        this.fGZ = j;
    }

    public final void run() {
        this.fGY.gnt.setPullDownBackgroundColor((int) this.fGZ);
    }
}
