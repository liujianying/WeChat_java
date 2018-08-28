package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletDelayTransferSettingUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WalletDelayTransferSettingUI phu;

    WalletDelayTransferSettingUI$2(WalletDelayTransferSettingUI walletDelayTransferSettingUI) {
        this.phu = walletDelayTransferSettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.phu.finish();
        return false;
    }
}
