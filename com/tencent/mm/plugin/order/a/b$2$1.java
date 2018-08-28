package com.tencent.mm.plugin.order.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.a.b.2;
import com.tencent.mm.plugin.order.model.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class b$2$1 implements Runnable {
    final /* synthetic */ String fhM;
    final /* synthetic */ 2 lNp;

    b$2$1(2 2, String str) {
        this.lNp = 2;
        this.fhM = str;
    }

    public final void run() {
        b bVar = this.lNp.lNo;
        g.Eg().Ds();
        if (bVar.lNk == null) {
            bVar.lNk = new b();
        }
        b bVar2 = bVar.lNk;
        String str = this.fhM;
        if (!bi.oW(str)) {
            Map z = bl.z(str, "sysmsg");
            if (z != null) {
                try {
                    str = (String) z.get(".sysmsg.wxpay.transid");
                    if (!bi.oW(str)) {
                        x.d("MicroMsg.WalletOrdersManager", "transid " + str);
                        if (!bVar2.lNE.contains(str)) {
                            bVar2.lNE.add(str);
                            g.Ek();
                            g.Ei().DT().set(204817, Integer.valueOf(bVar2.lNE.size()));
                            x.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + bVar2.lNE.size());
                            bVar2.bmr();
                            b.bmn().auM();
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.WalletOrdersManager", "cmdid error");
                }
            }
        }
    }
}
