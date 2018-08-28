package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBalanceManagerUI$5 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$5(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        WalletBalanceManagerUI.c(this.pax);
    }
}
