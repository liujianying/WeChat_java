package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSelectProfessionUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSelectProfessionUI pyr;

    WalletSelectProfessionUI$1(WalletSelectProfessionUI walletSelectProfessionUI) {
        this.pyr = walletSelectProfessionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pyr.setResult(0);
        this.pyr.finish();
        return true;
    }
}
