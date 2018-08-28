package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSelectBankcardModeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSelectBankcardModeUI paR;

    WalletSelectBankcardModeUI$1(WalletSelectBankcardModeUI walletSelectBankcardModeUI) {
        this.paR = walletSelectBankcardModeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.paR.setResult(0);
        this.paR.finish();
        return true;
    }
}
