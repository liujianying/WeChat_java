package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletPayUI$13 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;
    final /* synthetic */ int pgU;

    WalletPayUI$13(WalletPayUI walletPayUI, int i) {
        this.pgT = walletPayUI;
        this.pgU = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pgT.W(this.pgU, false);
    }
}
