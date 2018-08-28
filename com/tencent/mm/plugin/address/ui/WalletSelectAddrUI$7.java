package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSelectAddrUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSelectAddrUI fae;

    WalletSelectAddrUI$7(WalletSelectAddrUI walletSelectAddrUI) {
        this.fae = walletSelectAddrUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.fae.setResult(0);
        this.fae.finish();
        return true;
    }
}
