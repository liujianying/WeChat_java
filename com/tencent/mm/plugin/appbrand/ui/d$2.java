package com.tencent.mm.plugin.appbrand.ui;

class d$2 implements Runnable {
    final /* synthetic */ d guW;

    d$2(d dVar) {
        this.guW = dVar;
    }

    public final void run() {
        if (d.b(this.guW) != null) {
            d.b(this.guW).setLoadingIconVisibility(true);
        }
    }
}
