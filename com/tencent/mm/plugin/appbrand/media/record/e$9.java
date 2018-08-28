package com.tencent.mm.plugin.appbrand.media.record;

class e$9 implements Runnable {
    final /* synthetic */ e giH;

    e$9(e eVar) {
        this.giH = eVar;
    }

    public final void run() {
        synchronized (e.f(this.giH)) {
            e.i(this.giH);
        }
    }
}
