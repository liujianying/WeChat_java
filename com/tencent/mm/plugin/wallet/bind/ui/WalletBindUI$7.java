package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBindUI$7 implements OnClickListener {
    final /* synthetic */ WalletBindUI pdy;

    WalletBindUI$7(WalletBindUI walletBindUI) {
        this.pdy = walletBindUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pdy.finish();
    }
}
