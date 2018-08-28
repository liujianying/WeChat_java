package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.mm.plugin.wallet_core.model.ae;

class WalletBindUI$2 implements Runnable {
    final /* synthetic */ WalletBindUI pdy;

    WalletBindUI$2(WalletBindUI walletBindUI) {
        this.pdy = walletBindUI;
    }

    public final void run() {
        if (!WalletBindUI.a(this.pdy)) {
            if (WalletBindUI.b(this.pdy) == 4) {
                WalletBindUI.d(this.pdy).a(new 1(this), new ae().bPo());
            } else {
                WalletBindUI.c(this.pdy);
            }
            if (!WalletBindUI.a(this.pdy)) {
                WalletBindUI.e(this.pdy);
            }
        }
    }
}
