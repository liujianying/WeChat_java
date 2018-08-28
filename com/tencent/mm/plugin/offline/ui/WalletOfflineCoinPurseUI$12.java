package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.ci;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.e;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$12 extends c<ci> {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$12(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
        this.sFo = ci.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ci ciVar = (ci) bVar;
        x.d("MicroMsg.WalletOfflineCoinPurseUI", "do offline showcode");
        k.bkO();
        k.bkQ();
        o oVar = new o(e.bkH(), WalletOfflineCoinPurseUI.b(this.lMe), ciVar.bJP.bJQ);
        g.Ek();
        g.Eh().dpP.a(oVar, 0);
        return false;
    }
}
