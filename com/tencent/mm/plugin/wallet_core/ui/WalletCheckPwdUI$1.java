package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletCheckPwdUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletCheckPwdUI pvi;

    WalletCheckPwdUI$1(WalletCheckPwdUI walletCheckPwdUI) {
        this.pvi = walletCheckPwdUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WalletCheckPwdUI.a(this.pvi);
        return false;
    }
}
