package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class WalletCardElementUI$12 implements OnCheckedChangeListener {
    final /* synthetic */ WalletCardElementUI pun;

    WalletCardElementUI$12(WalletCardElementUI walletCardElementUI) {
        this.pun = walletCardElementUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        WalletCardElementUI.b(this.pun);
    }
}
