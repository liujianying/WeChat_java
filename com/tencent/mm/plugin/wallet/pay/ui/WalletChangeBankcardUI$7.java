package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletChangeBankcardUI$7 implements OnCancelListener {
    final /* synthetic */ WalletChangeBankcardUI pfC;

    WalletChangeBankcardUI$7(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.pfC = walletChangeBankcardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.pfC.eWo = null;
        if (WalletChangeBankcardUI.b(this.pfC).getVisibility() != 0) {
            this.pfC.bNE();
        }
        this.pfC.pfB = null;
    }
}
