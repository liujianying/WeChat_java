package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletVerifyCodeUI$6 implements OnClickListener {
    final /* synthetic */ WalletVerifyCodeUI pyT;

    WalletVerifyCodeUI$6(WalletVerifyCodeUI walletVerifyCodeUI) {
        this.pyT = walletVerifyCodeUI;
    }

    public final void onClick(View view) {
        if (!WalletVerifyCodeUI.a(this.pyT, WalletVerifyCodeUI.c(this.pyT))) {
            this.pyT.bQF();
        }
    }
}
