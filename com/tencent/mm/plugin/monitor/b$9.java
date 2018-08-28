package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class b$9 implements Runnable {
    final /* synthetic */ b lsb;

    b$9(b bVar) {
        this.lsb = bVar;
    }

    public final void run() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        b.b(this.lsb);
        b.c(this.lsb);
        b.d(this.lsb);
        b.e(this.lsb);
        b.f(this.lsb);
        g.Em();
        ah.M(b.g(this.lsb));
        g.Em().h(b.g(this.lsb), 10000);
    }
}
