package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.te;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WalletOfflineCoinPurseUI$1 extends c<te> {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$1(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
        this.sFo = te.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        te teVar = (te) bVar;
        a.sFg.c(this);
        if (com.tencent.mm.plugin.offline.c.a.bma() && teVar.ceH.result == 0) {
            WalletOfflineCoinPurseUI.a(this.lMe);
        }
        return false;
    }
}
