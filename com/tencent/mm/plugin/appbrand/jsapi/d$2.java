package com.tencent.mm.plugin.appbrand.jsapi;

class d$2 implements Runnable {
    final /* synthetic */ d fEP;
    final /* synthetic */ String fEQ;
    final /* synthetic */ int fER;
    final /* synthetic */ String fwv;

    d$2(d dVar, String str, String str2, int i) {
        this.fEP = dVar;
        this.fEQ = str;
        this.fwv = str2;
        this.fER = i;
    }

    public final void run() {
        if (this.fEP.Sx) {
            d.a(this.fEP, this.fEQ, this.fwv, this.fER, false);
        }
    }
}
