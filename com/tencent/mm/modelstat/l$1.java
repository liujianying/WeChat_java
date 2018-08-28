package com.tencent.mm.modelstat;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;

class l$1 implements Runnable {
    final /* synthetic */ long ekp;
    final /* synthetic */ l ekq;

    l$1(l lVar, long j) {
        this.ekq = lVar;
        this.ekp = j;
    }

    public final void run() {
        long VF = bi.VF();
        long a = l.a(new File(g.Ei().cachePath), this.ekp);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), g.Ei().cachePath});
        a = l.a(new File(g.Ei().dqo), this.ekp);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), g.Ei().dqo});
        a = l.a(new File(g.Ei().dqo), this.ekp);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), g.Ei().dqo});
        a = l.a(new File(g.Ei().dqp), this.ekp);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), g.Ei().dqp});
        a = l.a(new File(aa.duN), this.ekp);
        x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", new Object[]{Long.valueOf(a), aa.duN});
        x.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", new Object[]{Long.valueOf(bi.VF() - VF)});
    }
}
