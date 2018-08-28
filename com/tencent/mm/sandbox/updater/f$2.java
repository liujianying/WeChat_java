package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.x;

class f$2 implements Runnable {
    final /* synthetic */ f sEk;
    final /* synthetic */ long sEl;

    f$2(f fVar, long j) {
        this.sEk = fVar;
        this.sEl = j;
    }

    public final void run() {
        x.d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", new Object[]{Long.valueOf(this.sEl)});
        f.a(this.sEk, f.a(this.sEk) + Math.max(0, this.sEl));
        f.a(this.sEk, false);
    }
}
