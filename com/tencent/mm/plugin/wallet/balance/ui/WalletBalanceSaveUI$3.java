package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.wallet_core.ui.a;

class WalletBalanceSaveUI$3 implements a {
    final /* synthetic */ WalletBalanceSaveUI paK;

    WalletBalanceSaveUI$3(WalletBalanceSaveUI walletBalanceSaveUI) {
        this.paK = walletBalanceSaveUI;
    }

    public final void fI(boolean z) {
        if (z) {
            WalletBalanceSaveUI.b(this.paK);
        } else {
            WalletBalanceSaveUI.c(this.paK).scrollTo(0, 0);
        }
    }
}
