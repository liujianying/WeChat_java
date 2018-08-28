package com.tencent.mm.graphics.b;

import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class d$1 extends TimerTask {
    final /* synthetic */ d djt;

    public d$1(d dVar) {
        this.djt = dVar;
    }

    public final void run() {
        synchronized (d.a(this.djt)) {
            if (d.b(this.djt)) {
                for (a Ck : d.c(this.djt).values()) {
                    Ck.Ck();
                }
            } else {
                x.w("MicroMsg.PerformanceMonitor", "hy: already stopped");
                cancel();
            }
        }
    }
}
