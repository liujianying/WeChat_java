package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletCheckPwdUI$4 implements OnClickListener {
    final /* synthetic */ WalletCheckPwdUI pvi;

    WalletCheckPwdUI$4(WalletCheckPwdUI walletCheckPwdUI) {
        this.pvi = walletCheckPwdUI;
    }

    public final void onClick(View view) {
        WalletCheckPwdUI.bQi();
        if (WalletCheckPwdUI.e(this.pvi) == 0) {
            WalletCheckPwdUI.a(this.pvi, 1);
            WalletCheckPwdUI.f(this.pvi);
        } else {
            WalletCheckPwdUI.a(this.pvi, 0);
        }
        WalletCheckPwdUI.g(this.pvi);
    }
}
