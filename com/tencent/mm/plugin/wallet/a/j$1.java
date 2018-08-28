package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements e {
    final /* synthetic */ sv pep;
    final /* synthetic */ String peq;
    final /* synthetic */ j per;

    j$1(j jVar, sv svVar, String str) {
        this.per = jVar;
        this.pep = svVar;
        this.peq = str;
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.Ek();
        g.Eh().dpP.b(1767, this);
        if (i == 0 && i2 == 0) {
            this.pep.cdJ.buffer = this.peq;
            this.pep.cdJ.cdN.run();
            return;
        }
        x.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", new Object[]{Integer.valueOf(i2), str});
        this.pep.cdJ.retCode = -1;
        this.pep.cdJ.cdN.run();
    }
}
