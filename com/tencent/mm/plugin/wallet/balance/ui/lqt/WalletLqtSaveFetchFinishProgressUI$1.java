package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletLqtSaveFetchFinishProgressUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletLqtSaveFetchFinishProgressUI pby;

    WalletLqtSaveFetchFinishProgressUI$1(WalletLqtSaveFetchFinishProgressUI walletLqtSaveFetchFinishProgressUI) {
        this.pby = walletLqtSaveFetchFinishProgressUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pby.finish();
        return false;
    }
}
