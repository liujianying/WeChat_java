package com.tencent.mm.plugin.appbrand.media.record;

class e$8 implements Runnable {
    final /* synthetic */ e giH;

    public e$8(e eVar) {
        this.giH = eVar;
    }

    public final void run() {
        synchronized (e.f(this.giH)) {
            this.giH.ali();
        }
    }
}
