package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.sdk.platformtools.al.a;

class WalletOfflineCoinPurseUI$30 implements a {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$30(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final boolean vD() {
        if (!WalletOfflineCoinPurseUI.K(this.lMe)) {
            WalletOfflineCoinPurseUI.E(this.lMe);
            WalletOfflineCoinPurseUI.F(this.lMe);
        }
        long L = (long) WalletOfflineCoinPurseUI.L(this.lMe);
        WalletOfflineCoinPurseUI.M(this.lMe).J(L, L);
        return false;
    }
}
