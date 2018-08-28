package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletPayUPayUI$3 implements OnCancelListener {
    final /* synthetic */ WalletPayUPayUI pFA;

    WalletPayUPayUI$3(WalletPayUPayUI walletPayUPayUI) {
        this.pFA = walletPayUPayUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WalletPayUPayUI.f(this.pFA);
        WalletPayUPayUI.g(this.pFA);
        if (this.pFA.bbR()) {
            this.pFA.finish();
        }
    }
}
