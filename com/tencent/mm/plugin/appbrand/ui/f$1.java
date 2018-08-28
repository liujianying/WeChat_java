package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.g;

class f$1 implements Runnable {
    final /* synthetic */ g fel;
    final /* synthetic */ Runnable ghr;
    final /* synthetic */ int gwG;

    f$1(g gVar, int i, Runnable runnable) {
        this.fel = gVar;
        this.gwG = i;
        this.ghr = runnable;
    }

    public final void run() {
        f.a(this.fel, this.gwG, this.ghr);
    }
}
