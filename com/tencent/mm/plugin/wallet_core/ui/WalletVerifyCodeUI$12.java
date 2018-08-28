package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class WalletVerifyCodeUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ WalletVerifyCodeUI pyT;

    WalletVerifyCodeUI$12(WalletVerifyCodeUI walletVerifyCodeUI) {
        this.pyT = walletVerifyCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pyT.YC();
        if (this.pyT.bND()) {
            this.pyT.showDialog(BaseReportManager.MAX_READ_COUNT);
        } else {
            this.pyT.finish();
        }
        return false;
    }
}
