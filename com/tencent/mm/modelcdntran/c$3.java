package com.tencent.mm.modelcdntran;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 extends a {
    final /* synthetic */ c dPb;

    c$3(c cVar) {
        this.dPb = cVar;
    }

    public final void ev(int i) {
        x.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", new Object[]{Integer.valueOf(i)});
        if ((i == 4 || i == 6) && g.Eg().Dx()) {
            this.dPb.dOR.removeMessages(1);
            BaseEvent.onNetworkChange();
        }
    }
}
