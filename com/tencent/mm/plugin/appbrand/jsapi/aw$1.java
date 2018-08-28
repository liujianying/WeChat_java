package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ah;

class aw$1 implements Runnable {
    final /* synthetic */ aw fGA;
    final /* synthetic */ p fGz;

    aw$1(aw awVar, p pVar) {
        this.fGA = awVar;
        this.fGz = pVar;
    }

    public final void run() {
        ah.M(this.fGz.gnF);
        this.fGz.alQ();
    }
}
