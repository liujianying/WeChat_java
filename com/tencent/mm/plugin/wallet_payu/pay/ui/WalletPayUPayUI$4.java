package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletPayUPayUI$4 implements OnClickListener {
    final /* synthetic */ WalletPayUPayUI pFA;

    WalletPayUPayUI$4(WalletPayUPayUI walletPayUPayUI) {
        this.pFA = walletPayUPayUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        WalletPayUPayUI.h(this.pFA).putInt("key_pay_flag", 3);
        this.pFA.J(WalletPayUPayUI.i(this.pFA));
    }
}
