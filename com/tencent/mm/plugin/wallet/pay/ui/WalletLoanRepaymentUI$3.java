package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletLoanRepaymentUI$3 implements OnCancelListener {
    final /* synthetic */ WalletLoanRepaymentUI pfP;

    WalletLoanRepaymentUI$3(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.pfP = walletLoanRepaymentUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.pfP.oZD != null) {
            this.pfP.oZD.cancel();
            this.pfP.setResult(0);
            this.pfP.finish();
        }
    }
}
