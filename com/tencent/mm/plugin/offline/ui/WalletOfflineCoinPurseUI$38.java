package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.al;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$38 extends c<al> {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$38(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
        this.sFo = al.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        al alVar = (al) bVar;
        if (a.lMM != 3 || !(alVar instanceof al) || !alVar.bHN.bHO) {
            return false;
        }
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "finish button event!");
        this.lMe.finish();
        return true;
    }
}
