package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletMultiRcptSelectUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletMultiRcptSelectUI eZU;

    WalletMultiRcptSelectUI$1(WalletMultiRcptSelectUI walletMultiRcptSelectUI) {
        this.eZU = walletMultiRcptSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WalletMultiRcptSelectUI.a(this.eZU);
        return true;
    }
}
