package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.ks;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$35 extends c<ks> {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$35(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
        this.sFo = ks.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ks) bVar).bVf.aeo != hashCode()) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "has create a new ui, finish self");
            this.lMe.finish();
        }
        return false;
    }
}
