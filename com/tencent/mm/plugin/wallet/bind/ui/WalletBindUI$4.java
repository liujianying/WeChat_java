package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.wallet_core.c.a;

class WalletBindUI$4 implements a {
    final /* synthetic */ WalletBindUI pdy;

    WalletBindUI$4(WalletBindUI walletBindUI) {
        this.pdy = walletBindUI;
    }

    public final Intent n(int i, Bundle bundle) {
        return new Intent(this.pdy.mController.tml, WalletBankcardManageUI.class);
    }
}
