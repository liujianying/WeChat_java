package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletLqtSimpleCheckPwdUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletLqtSimpleCheckPwdUI pcp;

    WalletLqtSimpleCheckPwdUI$1(WalletLqtSimpleCheckPwdUI walletLqtSimpleCheckPwdUI) {
        this.pcp = walletLqtSimpleCheckPwdUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pcp.finish();
        return false;
    }
}
