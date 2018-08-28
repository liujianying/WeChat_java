package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletPayUChangeBankcardUI$3 implements OnCancelListener {
    final /* synthetic */ WalletPayUChangeBankcardUI pFy;

    WalletPayUChangeBankcardUI$3(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        this.pFy = walletPayUChangeBankcardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WalletPayUChangeBankcardUI.j(this.pFy);
        if (WalletPayUChangeBankcardUI.k(this.pFy).getVisibility() != 0) {
            WalletPayUChangeBankcardUI.l(this.pFy);
        }
    }
}
