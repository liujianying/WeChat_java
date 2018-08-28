package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletCardSelectUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WalletCardSelectUI puJ;

    WalletCardSelectUI$2(WalletCardSelectUI walletCardSelectUI) {
        this.puJ = walletCardSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.puJ.finish();
        return true;
    }
}
