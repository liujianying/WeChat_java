package com.tencent.mm.plugin.backup.c;

class d$1 implements Runnable {
    final /* synthetic */ d gUG;
    final /* synthetic */ int gUs;

    d$1(d dVar, int i) {
        this.gUG = dVar;
        this.gUs = i;
    }

    public final void run() {
        if (d.a(this.gUG) != null) {
            d.a(this.gUG).mw(this.gUs);
        }
    }
}
