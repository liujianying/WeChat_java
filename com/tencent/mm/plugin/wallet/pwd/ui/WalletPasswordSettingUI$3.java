package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletPasswordSettingUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ WalletPasswordSettingUI pif;

    WalletPasswordSettingUI$3(WalletPasswordSettingUI walletPasswordSettingUI) {
        this.pif = walletPasswordSettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pif.finish();
        return true;
    }
}
