package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletConfirmCardIDUI$2 implements OnClickListener {
    final /* synthetic */ WalletConfirmCardIDUI pvp;

    WalletConfirmCardIDUI$2(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        this.pvp = walletConfirmCardIDUI;
    }

    public final void onClick(View view) {
        if (!(WalletConfirmCardIDUI.a(this.pvp).isShown() || WalletConfirmCardIDUI.b(this.pvp))) {
            WalletConfirmCardIDUI.c(this.pvp).setVisibility(0);
            WalletConfirmCardIDUI.d(this.pvp).setVisibility(0);
        }
        WalletConfirmCardIDUI.e(this.pvp);
    }
}
