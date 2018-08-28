package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletLoanRepaymentUI$5 implements OnClickListener {
    final /* synthetic */ WalletLoanRepaymentUI pfP;

    WalletLoanRepaymentUI$5(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.pfP = walletLoanRepaymentUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.pfP.bbR()) {
            this.pfP.finish();
        }
    }
}
