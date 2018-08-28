package com.tencent.mm.plugin.appbrand.ui;

class h$2 implements Runnable {
    final /* synthetic */ String dhm;
    final /* synthetic */ String etb;
    final /* synthetic */ h gwP;

    h$2(h hVar, String str, String str2) {
        this.gwP = hVar;
        this.dhm = str;
        this.etb = str2;
    }

    public final void run() {
        h.a(this.gwP, this.dhm, this.etb);
    }
}
