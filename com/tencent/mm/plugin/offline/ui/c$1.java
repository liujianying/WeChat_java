package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$1 extends c<te> {
    final /* synthetic */ PayInfo lLd;
    final /* synthetic */ c lLe;

    c$1(c cVar, PayInfo payInfo) {
        this.lLe = cVar;
        this.lLd = payInfo;
        this.sFo = te.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        te teVar = (te) bVar;
        a.sFg.c(this);
        if (teVar.ceH.result == 0) {
            com.tencent.mm.plugin.offline.a.c cVar = new com.tencent.mm.plugin.offline.a.c(this.lLd.bOd, this.lLd.bVY, this.lLd.bVU);
            g.Ek();
            g.Eh().dpP.a(cVar, 0);
            com.tencent.mm.plugin.offline.g.bkK();
            this.lLe.lKZ.blc();
        } else if (teVar.ceH.result == -1) {
            com.tencent.mm.plugin.offline.g.bkK();
            this.lLe.lKZ.blc();
        }
        return false;
    }
}
