package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.c.a;

class WalletLoanRepaymentUI$6 implements a {
    final /* synthetic */ WalletLoanRepaymentUI pfP;

    WalletLoanRepaymentUI$6(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.pfP = walletLoanRepaymentUI;
    }

    public final Intent n(int i, Bundle bundle) {
        if (i == -1) {
            WalletLoanRepaymentUI.b(this.pfP, WalletLoanRepaymentUI.b(this.pfP));
        } else {
            ad bOX = o.bOX();
            if (bOX.bPh()) {
                WalletLoanRepaymentUI.a(this.pfP, bOX.bPi(), WalletLoanRepaymentUI.d(this.pfP), WalletLoanRepaymentUI.e(this.pfP));
            } else {
                this.pfP.setResult(0, null);
            }
        }
        return null;
    }
}
