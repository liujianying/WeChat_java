package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBalanceFetchUI$7 implements OnClickListener {
    final /* synthetic */ WalletBalanceFetchUI pad;

    WalletBalanceFetchUI$7(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.pad = walletBalanceFetchUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        WalletBalanceFetchUI.j(this.pad);
    }
}
