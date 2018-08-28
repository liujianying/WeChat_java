package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletWXCreditDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditDetailUI qxp;

    WalletWXCreditDetailUI$2(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        this.qxp = walletWXCreditDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qxp.YC();
        this.qxp.finish();
        return true;
    }
}
