package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.page.p;

class a$4 implements Runnable {
    final /* synthetic */ String dho;
    final /* synthetic */ p fGY;
    final /* synthetic */ a gcK;

    a$4(a aVar, p pVar, String str) {
        this.gcK = aVar;
        this.fGY = pVar;
        this.dho = str;
    }

    public final void run() {
        this.fGY.gnt.setPullDownText(this.dho);
    }
}
