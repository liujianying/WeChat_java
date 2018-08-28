package com.tencent.mm.plugin.appbrand.widget;

class c$1 implements Runnable {
    final /* synthetic */ String gEo;
    final /* synthetic */ String gEp;
    final /* synthetic */ String gEq;
    final /* synthetic */ String gEr;
    final /* synthetic */ c gEs;

    c$1(c cVar, String str, String str2, String str3, String str4) {
        this.gEs = cVar;
        this.gEo = str;
        this.gEp = str2;
        this.gEq = str3;
        this.gEr = str4;
    }

    public final void run() {
        c.a(this.gEs, this.gEo, this.gEp);
        c.b(this.gEs, this.gEq, this.gEr);
        c.a(this.gEs);
    }
}
