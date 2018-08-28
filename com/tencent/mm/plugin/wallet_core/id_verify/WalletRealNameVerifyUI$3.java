package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import android.view.View.OnClickListener;

class WalletRealNameVerifyUI$3 implements OnClickListener {
    final /* synthetic */ WalletRealNameVerifyUI pkE;

    WalletRealNameVerifyUI$3(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.pkE = walletRealNameVerifyUI;
    }

    public final void onClick(View view) {
        WalletRealNameVerifyUI.a(this.pkE, WalletRealNameVerifyUI.b(this.pkE).getText(), WalletRealNameVerifyUI.c(this.pkE).getText());
    }
}
