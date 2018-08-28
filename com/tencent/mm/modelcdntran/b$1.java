package com.tencent.mm.modelcdntran;

import com.tencent.mm.model.am;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b dOP;

    b$1(b bVar) {
        this.dOP = bVar;
    }

    public final boolean vD() {
        if (b.a(this.dOP) == 0 && b.b(this.dOP) == 0) {
            return false;
        }
        x.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", b.c(this.dOP), Integer.valueOf(b.a(this.dOP)), Integer.valueOf(b.b(this.dOP)));
        if (am.a.dBs == null) {
            x.e("MicroMsg.CdnTransportEngine", "getNetStat null");
            return false;
        }
        am.a.dBs.aY(b.b(this.dOP), b.a(this.dOP));
        b.d(this.dOP);
        b.e(this.dOP);
        return true;
    }
}
