package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;

class WalletLqtSaveFetchUI$3 implements OnClickListener {
    final /* synthetic */ WalletLqtSaveFetchUI pcc;

    WalletLqtSaveFetchUI$3(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.pcc = walletLqtSaveFetchUI;
    }

    public final void onClick(View view) {
        WalletLqtSaveFetchUI.k(this.pcc).setChecked(!WalletLqtSaveFetchUI.k(this.pcc).isChecked());
    }
}
