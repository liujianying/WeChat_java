package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletBalanceManagerUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$1(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (WalletBalanceManagerUI.a(this.pax)) {
            this.pax.YC();
            this.pax.showDialog(1000);
        } else {
            this.pax.finish();
        }
        return true;
    }
}
