package com.tencent.mm.plugin.appbrand.ui.recents;

class e$3 implements Runnable {
    final /* synthetic */ e gAf;

    e$3(e eVar) {
        this.gAf = eVar;
    }

    public final void run() {
        e.a(this.gAf);
        if (e.b(this.gAf)) {
            e.c(this.gAf).performClick();
            e.d(this.gAf);
        }
    }
}
