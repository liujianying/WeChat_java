package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletPayUI$15 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$15(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pgT.pgr.putInt("key_pay_flag", 3);
        this.pgT.J(this.pgT.pgr);
    }
}
