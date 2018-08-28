package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class j$2 implements e {
    final /* synthetic */ sv pep;
    final /* synthetic */ j per;
    final /* synthetic */ int pes;

    j$2(j jVar, int i, sv svVar) {
        this.per = jVar;
        this.pes = i;
        this.pep = svVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.Ek();
        g.Eh().dpP.b(1767, this);
        if (i == 0 && i2 == 0) {
            int i3 = this.pes;
            String str2 = this.pep.cdI.buffer;
            switch (i3) {
                case 1:
                    g.Ek();
                    g.Ei().DT().a(a.sYJ, str2);
                    break;
                case 2:
                    g.Ek();
                    g.Ei().DT().a(a.sYK, str2);
                    break;
                case 4:
                    g.Ek();
                    g.Ei().DT().a(a.sYL, str2);
                    break;
                case 8:
                    g.Ek();
                    g.Ei().DT().a(a.sYM, str2);
                    break;
            }
            this.pep.cdJ.cdN.run();
            return;
        }
        x.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", new Object[]{Integer.valueOf(i2), str});
        this.pep.cdJ.retCode = -1;
        this.pep.cdJ.cdN.run();
    }
}
