package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.1;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.monitor.b.13;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$13$2 implements Runnable {
    final /* synthetic */ 13 lsn;
    final /* synthetic */ a lso;

    b$13$2(13 13, a aVar) {
        this.lsn = 13;
        this.lso = aVar;
    }

    public final void run() {
        int i;
        b.a(this.lsn.lsb, null);
        List bda = ((i) g.l(i.class)).Gx().bda();
        if (bi.cX(bda)) {
            x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
            i = 0;
        } else {
            e.post(new 1(bda), "checkUnfinishedDeleteMsgTask");
            i = bda.size();
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            h.mEJ.a(418, 8, 1, true);
        }
        b.a(this.lsn.lsb, b.a(this.lsn.lsb, this.lso));
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[]{b.o(this.lsn.lsb)});
    }
}
