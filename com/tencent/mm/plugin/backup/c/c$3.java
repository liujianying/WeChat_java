package com.tencent.mm.plugin.backup.c;

class c$3 implements Runnable {
    final /* synthetic */ c gUr;
    final /* synthetic */ int gUs;

    c$3(c cVar, int i) {
        this.gUr = cVar;
        this.gUs = i;
    }

    public final void run() {
        if (c.o(this.gUr) != null) {
            c.o(this.gUr).mw(this.gUs);
        }
    }
}
