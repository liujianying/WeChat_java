package com.tencent.mm.modelcdntran;

import com.tencent.mm.g.a.jb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class c$2 extends c<jb> {
    final /* synthetic */ c dPb;

    c$2(c cVar) {
        this.dPb = cVar;
        this.sFo = jb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (ao.isConnected(ad.getContext())) {
            x.i("MicroMsg.CdnTransportService", "cdntra mm on network change callback ");
            this.dPb.dOR.removeMessages(1);
            this.dPb.dOR.sendEmptyMessageDelayed(1, 10000);
        }
        return false;
    }
}
