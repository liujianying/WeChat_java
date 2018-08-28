package com.tencent.mm.plugin.wallet.balance.ui;

class WalletBalanceFetchUI$18 implements Runnable {
    final /* synthetic */ int mwk;
    final /* synthetic */ WalletBalanceFetchUI pad;

    WalletBalanceFetchUI$18(WalletBalanceFetchUI walletBalanceFetchUI, int i) {
        this.pad = walletBalanceFetchUI;
        this.mwk = i;
    }

    public final void run() {
        WalletBalanceFetchUI.h(this.pad).scrollBy(0, this.mwk);
    }
}
