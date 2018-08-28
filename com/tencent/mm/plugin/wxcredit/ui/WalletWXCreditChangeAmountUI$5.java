package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletWXCreditChangeAmountUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI qxj;

    WalletWXCreditChangeAmountUI$5(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.qxj = walletWXCreditChangeAmountUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qxj.YC();
        this.qxj.showDialog(3);
        return true;
    }
}
