package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletLoanRepaymentUI$2 implements OnClickListener {
    final /* synthetic */ WalletLoanRepaymentUI pfP;

    WalletLoanRepaymentUI$2(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.pfP = walletLoanRepaymentUI;
    }

    public final void onClick(View view) {
        WalletLoanRepaymentUI.c(this.pfP);
        if (this.pfP.oZD != null) {
            this.pfP.oZD.dismiss();
        }
    }
}
