package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletBindDepositUI$2 implements OnClickListener {
    final /* synthetic */ WalletBindDepositUI qwM;

    WalletBindDepositUI$2(WalletBindDepositUI walletBindDepositUI) {
        this.qwM = walletBindDepositUI;
    }

    public final void onClick(View view) {
        if (WalletBindDepositUI.e(this.qwM)) {
            this.qwM.cDL().m(new Object[]{WalletBindDepositUI.a(this.qwM).getText(), WalletBindDepositUI.d(this.qwM).lMV, WalletBindDepositUI.f(this.qwM).getText(), WalletBindDepositUI.d(this.qwM).pnw, Boolean.valueOf(false)});
        }
    }
}
