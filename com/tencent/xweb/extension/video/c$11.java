package com.tencent.xweb.extension.video;

class c$11 implements Runnable {
    final /* synthetic */ c vCb;

    c$11(c cVar) {
        this.vCb = cVar;
    }

    public final void run() {
        if (c.r(this.vCb) != null) {
            c.r(this.vCb).setVisibility(0);
        }
    }
}
