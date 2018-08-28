package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.c;

class WalletLoanRepaymentUI$1 implements c {
    final /* synthetic */ WalletLoanRepaymentUI pfP;

    WalletLoanRepaymentUI$1(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.pfP = walletLoanRepaymentUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        WalletLoanRepaymentUI.a(this.pfP, str);
        this.pfP.a(new s(WalletLoanRepaymentUI.a(this.pfP), WalletLoanRepaymentUI.b(this.pfP), (byte) 0), true, true);
    }
}
