package com.tencent.mm.plugin.gif;

class c$5 implements Runnable {
    final /* synthetic */ c kie;

    c$5(c cVar) {
        this.kie = cVar;
    }

    public final void run() {
        MMGIFJNI.saveRemainder(c.d(this.kie));
    }
}
