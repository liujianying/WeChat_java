package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.monitor.a.a;
import com.tencent.mm.plugin.monitor.b.13;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class b$13$1 implements a {
    final /* synthetic */ 13 lsn;

    b$13$1(13 13) {
        this.lsn = 13;
    }

    public final void a(int i, a aVar) {
        b.a(this.lsn.lsb, System.currentTimeMillis());
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[]{Integer.valueOf(i), Long.valueOf(b.l(this.lsn.lsb)), b.o(this.lsn.lsb), aVar});
        b.a(this.lsn.lsb, null);
        if (i == 0 && !aVar.dZm) {
            g.Ek();
            g.Ei().DT().a(aa.a.sUQ, Long.valueOf(b.l(this.lsn.lsb)));
            g.Ek();
            g.Ei().DT().lm(false);
            try {
                b.b(this.lsn.lsb, aVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "doReportSDInfo err!", new Object[0]);
                h.mEJ.a(418, 6, 1, true);
            }
        }
    }
}
