package com.tencent.mm.plugin.backup.c;

class c$4 implements Runnable {
    final /* synthetic */ c gUr;
    final /* synthetic */ int gUs;

    c$4(c cVar, int i) {
        this.gUr = cVar;
        this.gUs = i;
    }

    public final void run() {
        if (c.p(this.gUr) != null) {
            c.p(this.gUr).mv(this.gUs);
        }
    }
}
