package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSecuritySettingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSecuritySettingUI piD;

    WalletSecuritySettingUI$1(WalletSecuritySettingUI walletSecuritySettingUI) {
        this.piD = walletSecuritySettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.piD.finish();
        return false;
    }
}
