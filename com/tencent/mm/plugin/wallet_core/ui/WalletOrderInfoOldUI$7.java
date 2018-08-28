package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletOrderInfoOldUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    WalletOrderInfoOldUI$7(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pwD.done();
        return true;
    }
}
