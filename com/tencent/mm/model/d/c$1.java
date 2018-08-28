package com.tencent.mm.model.d;

import com.tencent.mm.ar.k;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements Runnable {
    final /* synthetic */ c dFv;

    public c$1(c cVar) {
        this.dFv = cVar;
    }

    public final void run() {
        if (c.a(this.dFv)) {
            x.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
            return;
        }
        long j = c.b(this.dFv).getLong("trace_config_last_update_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j > 86400000 || j > currentTimeMillis) {
            c.c(this.dFv);
            c.d(this.dFv);
            au.DF().a(159, this.dFv);
            au.DF().a(160, this.dFv);
            au.DF().a(new k(21), 0);
            return;
        }
        x.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + j + " current time: " + currentTimeMillis + " in same day");
    }
}
