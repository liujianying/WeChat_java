package com.tencent.mm.plugin.appbrand.jsapi;

class d$1 implements Runnable {
    final /* synthetic */ String fEO;
    final /* synthetic */ d fEP;
    final /* synthetic */ String fwv;
    final /* synthetic */ String fzV;

    d$1(d dVar, String str, String str2, String str3) {
        this.fEP = dVar;
        this.fzV = str;
        this.fwv = str2;
        this.fEO = str3;
    }

    public final void run() {
        this.fEP.fEJ.a(this.fzV, this.fwv, d.tj(this.fEO));
    }
}
