package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.c.a;

class WalletOfflineCoinPurseUI$26 implements Runnable {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$26(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final void run() {
        c A = WalletOfflineCoinPurseUI.A(this.lMe);
        a.e(A.mActivity, A.lLc);
        WalletOfflineCoinPurseUI.G(this.lMe);
    }
}
