package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.storage.ab;

final class c$j implements Runnable {
    final /* synthetic */ ab mjM;
    final /* synthetic */ c mjy;

    c$j(c cVar, ab abVar) {
        this.mjy = cVar;
        this.mjM = abVar;
    }

    public final void run() {
        this.mjy.mjt.K(this.mjM);
    }
}
