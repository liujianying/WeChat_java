package com.tencent.xweb.extension.video;

class c$7 implements Runnable {
    final /* synthetic */ c vCb;

    c$7(c cVar) {
        this.vCb = cVar;
    }

    public final void run() {
        c.p(this.vCb).setVisibility(0);
    }
}
