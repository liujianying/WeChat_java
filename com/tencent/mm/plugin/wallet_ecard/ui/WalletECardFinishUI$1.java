package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletECardFinishUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletECardFinishUI pCu;

    WalletECardFinishUI$1(WalletECardFinishUI walletECardFinishUI) {
        this.pCu = walletECardFinishUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.WalletECardFinishUI", "press back btn");
        WalletECardFinishUI.a(this.pCu).performClick();
        return false;
    }
}
