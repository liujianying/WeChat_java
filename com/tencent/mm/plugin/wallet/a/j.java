package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class j extends c<sv> {
    public j() {
        this.sFo = sv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sv svVar = (sv) bVar;
        g.Ek();
        int intValue = ((Integer) g.Ei().DT().get(a.sTs, Integer.valueOf(0))).intValue();
        int GM = q.GM();
        svVar.cdJ.retCode = 0;
        if (GM == 4) {
            if (intValue != svVar.cdI.cdM) {
                x.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong region, client: %s, req: %s", new Object[]{Integer.valueOf(intValue), Integer.valueOf(svVar.cdI.cdM)});
                svVar.cdJ.retCode = -1;
            } else if ("fetch".equals(svVar.cdI.action)) {
                String str;
                x.i("MicroMsg.HandleWCPayWalletBufferListener", "do fetch");
                switch (intValue) {
                    case 1:
                        g.Ek();
                        str = (String) g.Ei().DT().get(a.sYJ, "");
                        break;
                    case 2:
                        g.Ek();
                        str = (String) g.Ei().DT().get(a.sYK, "");
                        break;
                    case 4:
                        g.Ek();
                        str = (String) g.Ei().DT().get(a.sYL, "");
                        break;
                    case 8:
                        g.Ek();
                        str = (String) g.Ei().DT().get(a.sYM, "");
                        break;
                    default:
                        str = "";
                        break;
                }
                if (bi.oW(str)) {
                    x.i("MicroMsg.HandleWCPayWalletBufferListener", "fetch empty buffer");
                    svVar.cdJ.retCode = -2;
                } else {
                    a(svVar, new 1(this, svVar, str));
                }
            } else if ("save".equals(svVar.cdI.action)) {
                x.i("MicroMsg.HandleWCPayWalletBufferListener", "do save");
                a(svVar, new 2(this, intValue, svVar));
            } else {
                x.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong action: %s", new Object[]{svVar.cdI.action});
                svVar.cdJ.retCode = -1;
            }
            svVar.cdJ.cdN.run();
        } else {
            x.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong type: %s", new Object[]{Integer.valueOf(GM)});
            svVar.cdJ.retCode = -1;
            svVar.cdJ.cdN.run();
        }
        return false;
    }

    private static void a(sv svVar, e eVar) {
        x.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
        g.Ek();
        g.Eh().dpP.a(1767, eVar);
        sv.a aVar = svVar.cdI;
        x.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[]{aVar.appId, aVar.nonceStr, aVar.bJT, aVar.cdK, aVar.cdL, aVar.signType, aVar.url});
        com.tencent.mm.plugin.wallet_core.c.a.a aVar2 = new com.tencent.mm.plugin.wallet_core.c.a.a(aVar.appId, aVar.nonceStr, aVar.bJT, aVar.cdK, aVar.cdL, aVar.signType, aVar.url);
        g.Ek();
        g.Eh().dpP.a(aVar2, 0);
    }
}
