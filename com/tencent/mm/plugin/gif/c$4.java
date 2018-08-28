package com.tencent.mm.plugin.gif;

class c$4 implements Runnable {
    final /* synthetic */ c kie;

    c$4(c cVar) {
        this.kie = cVar;
    }

    public final void run() {
        MMGIFJNI.reset(c.d(this.kie));
    }
}
