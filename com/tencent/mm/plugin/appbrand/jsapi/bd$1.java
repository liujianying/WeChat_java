package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.p;

class bd$1 implements Runnable {
    final /* synthetic */ p fGY;
    final /* synthetic */ String fHb;
    final /* synthetic */ bd fHc;

    bd$1(bd bdVar, p pVar, String str) {
        this.fHc = bdVar;
        this.fGY = pVar;
        this.fHb = str;
    }

    public final void run() {
        this.fGY.gnt.setBackgroundTextStyle(this.fHb);
    }
}
