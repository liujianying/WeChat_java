package com.tencent.mm.plugin.monitor;

import com.tencent.mm.sdk.platformtools.x;

class b$10 implements Runnable {
    final /* synthetic */ b lsb;

    b$10(b bVar) {
        this.lsb = bVar;
    }

    public final void run() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
        b.h(this.lsb);
    }
}
