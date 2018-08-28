package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.b;
import com.tencent.mm.modelmulti.p.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class p$f$1 implements b {
    final /* synthetic */ f eaQ;

    p$f$1(f fVar) {
        this.eaQ = fVar;
    }

    public final boolean ie(int i) {
        x.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", new Object[]{this.eaQ, this.eaQ.eaC, Integer.valueOf(this.eaQ.dYV), Long.valueOf(this.eaQ.eaP)});
        if ((this.eaQ.dYV & 1) > 0) {
            g.Ek();
            g.DF().a(new g(this.eaQ.eaP, bi.WP(bi.oV((String) g.Ei().DT().get(8195, null)))), 0);
        }
        p.a(this.eaQ.eay, this.eaQ);
        return true;
    }
}
