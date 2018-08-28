package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.text.SimpleDateFormat;
import java.util.Date;

class b$3 implements Runnable {
    final /* synthetic */ b lsb;

    b$3(b bVar) {
        this.lsb = bVar;
    }

    public final void run() {
        try {
            g.Ek();
            int intValue = ((Integer) g.Ei().DT().get(a.sUU, Integer.valueOf(0))).intValue();
            g.Ek();
            long longValue = ((Long) g.Ei().DT().get(a.sUT, Long.valueOf(0))).longValue();
            long q = b.q(this.lsb);
            Object obj = (intValue <= 0 || d.qVN == intValue) ? 1 : null;
            String str = intValue + ";" + d.qVN + ";" + (obj != null ? 1 : 0) + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(longValue)) + ";" + q;
            h.mEJ.a(418, 1, 1, true);
            h.mEJ.h(13778, new Object[]{Integer.valueOf(3), Integer.valueOf(1), str});
            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", new Object[]{str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportVersion err!", new Object[0]);
            h.mEJ.a(418, 2, 1, true);
        }
    }
}
