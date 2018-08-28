package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.x;

class f$3 implements Runnable {
    final /* synthetic */ f sEk;
    final /* synthetic */ long sEm;

    f$3(f fVar, long j) {
        this.sEk = fVar;
        this.sEm = j;
    }

    public final void run() {
        x.d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", new Object[]{Long.valueOf(this.sEm)});
        f.b(this.sEk, f.b(this.sEk) + Math.max(0, this.sEm));
        f.a(this.sEk, false);
    }
}
