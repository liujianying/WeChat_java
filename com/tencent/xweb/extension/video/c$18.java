package com.tencent.xweb.extension.video;

class c$18 implements Runnable {
    final /* synthetic */ c vCb;

    c$18(c cVar) {
        this.vCb = cVar;
    }

    public final void run() {
        c.a(this.vCb, true);
        c.j(this.vCb).setVisibility(0);
        this.vCb.cIz();
    }
}
