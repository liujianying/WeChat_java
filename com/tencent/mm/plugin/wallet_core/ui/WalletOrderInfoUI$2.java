package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOrderInfoUI$2 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoUI pxa;

    WalletOrderInfoUI$2(WalletOrderInfoUI walletOrderInfoUI) {
        this.pxa = walletOrderInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pxa.finish();
    }
}
