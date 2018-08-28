package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.ui.j;

class p$27 implements Runnable {
    final /* synthetic */ String fHb;
    final /* synthetic */ p gnH;
    final /* synthetic */ String gnP;

    p$27(p pVar, String str, String str2) {
        this.gnH = pVar;
        this.gnP = str;
        this.fHb = str2;
    }

    public final void run() {
        int aO = j.aO(this.gnP, -1);
        this.gnH.gnt.aK(this.fHb, aO);
        this.gnH.gnm.setBackgroundColor(aO);
    }
}
