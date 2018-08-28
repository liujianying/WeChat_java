package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletWXCreditChangeAmountResultUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountResultUI qwP;

    WalletWXCreditChangeAmountResultUI$1(WalletWXCreditChangeAmountResultUI walletWXCreditChangeAmountResultUI) {
        this.qwP = walletWXCreditChangeAmountResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qwP.cDK().a(this.qwP.mController.tml, 0, this.qwP.sy);
        return true;
    }
}
