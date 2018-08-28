package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletLockCheckPwdUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletLockCheckPwdUI phU;

    WalletLockCheckPwdUI$1(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        this.phU = walletLockCheckPwdUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
        WalletLockCheckPwdUI.a(this.phU);
        return true;
    }
}
