package com.tencent.mm.plugin.j;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.j.b.2;
import com.tencent.mm.plugin.j.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class b$2$1 implements Runnable {
    final /* synthetic */ 2 hsY;

    b$2$1(2 2) {
        this.hsY = 2;
    }

    public final void run() {
        x.i("MicroMsg.CalcWxService", "start to calc");
        if (this.hsY.hsX.avu()) {
            b bVar = this.hsY.hsX;
            if (bi.bH(((Long) g.Ei().DT().get(a.sYk, Long.valueOf(0))).longValue()) >= 259200000) {
                if (bVar.hsM != null) {
                    bVar.hsM.isStop = true;
                }
                bVar.hsM = new b();
                bVar.j(bVar.hsM);
                g.Ei().DT().a(a.sYk, Long.valueOf(bi.VF()));
                return;
            }
            return;
        }
        h.mEJ.a(664, 1, 1, false);
        b.i(this.hsY.hsX);
    }
}
