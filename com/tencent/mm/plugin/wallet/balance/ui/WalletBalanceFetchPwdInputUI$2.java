package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.c;

class WalletBalanceFetchPwdInputUI$2 implements c {
    final /* synthetic */ WalletBalanceFetchPwdInputUI oZE;

    WalletBalanceFetchPwdInputUI$2(WalletBalanceFetchPwdInputUI walletBalanceFetchPwdInputUI) {
        this.oZE = walletBalanceFetchPwdInputUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        WalletBalanceFetchPwdInputUI.a(this.oZE).dismiss();
        if (this.oZE.cDK() != null) {
            this.oZE.cDL().m(new Object[]{str});
        }
    }
}
