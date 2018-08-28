package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletIbgAdapterUI$2 implements OnClickListener {
    final /* synthetic */ WalletIbgAdapterUI pzd;

    WalletIbgAdapterUI$2(WalletIbgAdapterUI walletIbgAdapterUI) {
        this.pzd = walletIbgAdapterUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pzd.finish();
    }
}
