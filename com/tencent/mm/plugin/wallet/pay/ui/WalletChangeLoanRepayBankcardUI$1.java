package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletChangeLoanRepayBankcardUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletChangeLoanRepayBankcardUI pfF;

    WalletChangeLoanRepayBankcardUI$1(WalletChangeLoanRepayBankcardUI walletChangeLoanRepayBankcardUI) {
        this.pfF = walletChangeLoanRepayBankcardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pfF.setResult(-1, null);
        return true;
    }
}
