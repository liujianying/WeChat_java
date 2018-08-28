package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletWXCreditOpenNotifyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditOpenNotifyUI qxv;

    WalletWXCreditOpenNotifyUI$1(WalletWXCreditOpenNotifyUI walletWXCreditOpenNotifyUI) {
        this.qxv = walletWXCreditOpenNotifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qxv.setResult(-1);
        this.qxv.finish();
        return true;
    }
}
