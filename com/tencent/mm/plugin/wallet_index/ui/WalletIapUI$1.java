package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletIapUI$1 implements OnCancelListener {
    final /* synthetic */ WalletIapUI pDI;

    WalletIapUI$1(WalletIapUI walletIapUI) {
        this.pDI = walletIapUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.pDI.setResult(0);
        this.pDI.finish();
    }
}
