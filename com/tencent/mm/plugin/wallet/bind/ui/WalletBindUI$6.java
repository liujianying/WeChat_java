package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBindUI$6 implements OnClickListener {
    final /* synthetic */ WalletBindUI pdy;

    WalletBindUI$6(WalletBindUI walletBindUI) {
        this.pdy = walletBindUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pdy.finish();
    }
}
