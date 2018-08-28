package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.h.a;

class WalletForgotPwdUI$5 implements a {
    final /* synthetic */ WalletForgotPwdUI phK;

    WalletForgotPwdUI$5(WalletForgotPwdUI walletForgotPwdUI) {
        this.phK = walletForgotPwdUI;
    }

    public final void onClick(View view) {
        WalletForgotPwdUI.a(this.phK, true);
        WalletForgotPwdUI.a(this.phK);
    }
}
