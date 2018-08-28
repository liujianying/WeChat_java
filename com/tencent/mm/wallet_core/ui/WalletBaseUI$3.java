package com.tencent.mm.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletBaseUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBaseUI uYT;

    WalletBaseUI$3(WalletBaseUI walletBaseUI) {
        this.uYT = walletBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.uYT.bND()) {
            this.uYT.YC();
            this.uYT.showDialog(1000);
        } else {
            this.uYT.finish();
        }
        return true;
    }
}
