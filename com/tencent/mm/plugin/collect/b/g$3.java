package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class g$3 implements Runnable {
    final /* synthetic */ g hTZ;

    g$3(g gVar) {
        this.hTZ = gVar;
    }

    public final void run() {
        if (g.a(this.hTZ) != null && g.b(this.hTZ) && g.c(this.hTZ) == null) {
            x.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
            h.mEJ.a(699, 1, 1, false);
        }
    }
}
