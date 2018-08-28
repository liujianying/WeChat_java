package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletRealNameVerifyUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ WalletRealNameVerifyUI pkE;

    WalletRealNameVerifyUI$4(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.pkE = walletRealNameVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ((a) this.pkE.cDK()).c(this.pkE, 0);
        this.pkE.finish();
        return true;
    }
}
