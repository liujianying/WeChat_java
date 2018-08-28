package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.mm.plugin.wallet_core.ui.q.a;

class WalletBankcardManageUI$2 implements a {
    final /* synthetic */ WalletBankcardManageUI pdm;
    final /* synthetic */ Runnable pdn;

    WalletBankcardManageUI$2(WalletBankcardManageUI walletBankcardManageUI, Runnable runnable) {
        this.pdm = walletBankcardManageUI;
        this.pdn = runnable;
    }

    public final void bcc() {
        this.pdn.run();
    }

    public final void cancel() {
        WalletBankcardManageUI.c(this.pdm).bIq = false;
    }

    public final void bcd() {
        this.pdn.run();
    }
}
