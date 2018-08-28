package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSelectAddrUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSelectAddrUI fae;

    WalletSelectAddrUI$8(WalletSelectAddrUI walletSelectAddrUI) {
        this.fae = walletSelectAddrUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WalletSelectAddrUI.i(this.fae);
        return true;
    }
}
