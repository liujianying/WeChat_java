package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.sdk.platformtools.al.a;

class WalletOfflineCoinPurseUI$31 implements a {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$31(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final boolean vD() {
        WalletOfflineCoinPurseUI.a(this.lMe);
        if (WalletOfflineCoinPurseUI.o(this.lMe) != null && WalletOfflineCoinPurseUI.o(this.lMe).isShowing()) {
            WalletOfflineCoinPurseUI.o(this.lMe).dismiss();
        }
        g.bkK();
        WalletOfflineCoinPurseUI.N(this.lMe);
        if (com.tencent.mm.plugin.offline.c.a.bma()) {
            this.lMe.blc();
        }
        return false;
    }
}
