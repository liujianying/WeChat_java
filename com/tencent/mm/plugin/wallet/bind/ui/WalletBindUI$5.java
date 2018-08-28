package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBindUI$5 implements OnClickListener {
    final /* synthetic */ WalletBindUI pdy;

    WalletBindUI$5(WalletBindUI walletBindUI) {
        this.pdy = walletBindUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pdy.finish();
    }
}
