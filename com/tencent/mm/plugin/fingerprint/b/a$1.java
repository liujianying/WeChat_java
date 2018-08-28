package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.bq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ bq jgn;
    final /* synthetic */ a jgo;

    a$1(a aVar, bq bqVar) {
        this.jgo = aVar;
        this.jgn = bqVar;
    }

    public final void run() {
        if (this.jgn.bJb == null) {
            return;
        }
        if (this.jgn.bJb.retCode == 0) {
            x.i("MicroMsg.BaseFingerprintImp", "close finger print success!");
            if (q.GS()) {
                x.i("MicroMsg.BaseFingerprintImp", "now context is isPayUPay!");
                return;
            }
            x.i("MicroMsg.BaseFingerprintImp", "do bound query, update data");
            g.Ek();
            g.Eh().dpP.a(new y(null, 19), 0);
            return;
        }
        x.i("MicroMsg.BaseFingerprintImp", "close finger print failed!");
    }
}
