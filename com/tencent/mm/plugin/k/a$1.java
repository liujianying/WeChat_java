package com.tencent.mm.plugin.k;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ kg hJR;
    final /* synthetic */ kg hJS;
    final /* synthetic */ kg hJT;

    a$1(kg kgVar, kg kgVar2, kg kgVar3) {
        this.hJR = kgVar;
        this.hJS = kgVar2;
        this.hJT = kgVar3;
    }

    public final void run() {
        a aVar = new a();
        long j = -1;
        g.NA();
        if (!(g.NC() == null || this.hJR == null)) {
            g.NA();
            g.NC().a(this.hJR, this.hJS, this.hJT);
            j = aVar.Ad();
        }
        x.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[]{Long.valueOf(aVar.Ad()), Long.valueOf(j)});
    }
}
