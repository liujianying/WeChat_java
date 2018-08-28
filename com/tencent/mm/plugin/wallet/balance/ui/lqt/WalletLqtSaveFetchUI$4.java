package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class WalletLqtSaveFetchUI$4 implements OnCheckedChangeListener {
    final /* synthetic */ WalletLqtSaveFetchUI pcc;

    WalletLqtSaveFetchUI$4(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.pcc = walletLqtSaveFetchUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            WalletLqtSaveFetchUI.a(this.pcc, true);
        } else {
            WalletLqtSaveFetchUI.a(this.pcc, false);
        }
    }
}
