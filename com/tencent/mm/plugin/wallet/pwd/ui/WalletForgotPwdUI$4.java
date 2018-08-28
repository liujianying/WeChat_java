package com.tencent.mm.plugin.wallet.pwd.ui;

class WalletForgotPwdUI$4 implements Runnable {
    final /* synthetic */ WalletForgotPwdUI phK;

    WalletForgotPwdUI$4(WalletForgotPwdUI walletForgotPwdUI) {
        this.phK = walletForgotPwdUI;
    }

    public final void run() {
        WalletForgotPwdUI.b(this.phK).notifyDataSetChanged();
        WalletForgotPwdUI.c(this.phK);
    }
}
