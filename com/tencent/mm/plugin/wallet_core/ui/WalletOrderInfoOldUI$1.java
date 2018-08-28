package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOrderInfoOldUI$1 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    WalletOrderInfoOldUI$1(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pwD.done();
    }
}
