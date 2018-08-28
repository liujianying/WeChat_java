package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletBankcardIdUI$5 implements OnClickListener {
    final /* synthetic */ WalletBankcardIdUI psW;

    WalletBankcardIdUI$5(WalletBankcardIdUI walletBankcardIdUI) {
        this.psW = walletBankcardIdUI;
    }

    public final void onClick(View view) {
        this.psW.showDialog(1);
    }
}
