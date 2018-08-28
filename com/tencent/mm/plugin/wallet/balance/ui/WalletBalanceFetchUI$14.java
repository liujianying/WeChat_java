package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.wallet_core.ui.a;

class WalletBalanceFetchUI$14 implements a {
    final /* synthetic */ WalletBalanceFetchUI pad;

    WalletBalanceFetchUI$14(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.pad = walletBalanceFetchUI;
    }

    public final void fI(boolean z) {
        if (z) {
            WalletBalanceFetchUI.g(this.pad);
        } else {
            WalletBalanceFetchUI.h(this.pad).scrollTo(0, 0);
        }
    }
}
