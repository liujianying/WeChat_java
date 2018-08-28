package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;

class WalletBankcardManageUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBankcardManageUI pdm;

    WalletBankcardManageUI$3(WalletBankcardManageUI walletBankcardManageUI) {
        this.pdm = walletBankcardManageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pdm.finish();
        h.mEJ.h(14422, new Object[]{Integer.valueOf(4)});
        return true;
    }
}
