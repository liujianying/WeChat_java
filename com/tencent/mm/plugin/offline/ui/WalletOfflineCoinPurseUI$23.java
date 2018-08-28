package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$23 extends c<lf> {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$23(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
        this.sFo = lf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", " ecard finish: %s", new Object[]{Integer.valueOf(((lf) bVar).bVy.retCode)});
        this.lMe.a(new y(null, 8), false, false);
        return false;
    }
}
