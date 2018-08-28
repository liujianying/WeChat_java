package com.tencent.mm.modelcdntran;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$2 extends ag {
    final /* synthetic */ g dPN;

    g$2(g gVar, Looper looper) {
        this.dPN = gVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 1 && g.a(this.dPN) != 0) {
            x.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", new Object[]{Integer.valueOf(message.arg1), Long.valueOf(g.a(this.dPN)), Long.valueOf(bi.bH(g.a(this.dPN)))});
            g.DF().a(new e(r0), 0);
        }
    }
}
