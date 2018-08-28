package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ c kqs;

    c$2(c cVar) {
        this.kqs = cVar;
    }

    public final void run() {
        try {
            c cVar = this.kqs;
            cVar.kql = new c(v2protocal.lsT, 1, 6);
            cVar.kql.ey(20);
            cVar.kql.aN(true);
            cVar.kql.wm();
            cVar.kql.bDQ = -19;
            cVar.kql.t(1, false);
            cVar.kql.aM(true);
            cVar.kql.bEb = cVar.kqr;
            if (cVar.kql.wn()) {
                cVar.kql.aO(cVar.hEj);
                return;
            }
            x.e("MicroMsg.IPCallRecorder", "start record failed");
            if (cVar.kql.bDF != 13) {
                i.aXr().aXP();
            }
        } catch (Exception e) {
            x.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[]{e.getMessage()});
            i.aXr().aXP();
        }
    }
}
