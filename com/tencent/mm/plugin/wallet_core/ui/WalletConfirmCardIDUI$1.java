package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.c.p;

class WalletConfirmCardIDUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletConfirmCardIDUI pvp;

    WalletConfirmCardIDUI$1(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        this.pvp = walletConfirmCardIDUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        p.cDe();
        this.pvp.finish();
        return false;
    }
}
