package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOrderInfoNewUI$16 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI pwh;

    WalletOrderInfoNewUI$16(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.pwh = walletOrderInfoNewUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pwh.done();
    }
}
