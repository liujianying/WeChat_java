package com.tencent.mm.plugin.wallet.balance.ui;

class WalletBalanceSaveUI$6 implements Runnable {
    final /* synthetic */ int mwk;
    final /* synthetic */ WalletBalanceSaveUI paK;

    WalletBalanceSaveUI$6(WalletBalanceSaveUI walletBalanceSaveUI, int i) {
        this.paK = walletBalanceSaveUI;
        this.mwk = i;
    }

    public final void run() {
        WalletBalanceSaveUI.c(this.paK).scrollBy(0, this.mwk);
    }
}
