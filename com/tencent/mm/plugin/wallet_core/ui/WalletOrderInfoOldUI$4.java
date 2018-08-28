package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOrderInfoOldUI$4 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    WalletOrderInfoOldUI$4(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pwD.finish();
    }
}
