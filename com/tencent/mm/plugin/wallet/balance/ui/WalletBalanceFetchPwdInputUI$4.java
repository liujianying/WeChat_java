package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletBalanceFetchPwdInputUI$4 implements a {
    final /* synthetic */ WalletBalanceFetchPwdInputUI oZE;

    WalletBalanceFetchPwdInputUI$4(WalletBalanceFetchPwdInputUI walletBalanceFetchPwdInputUI) {
        this.oZE = walletBalanceFetchPwdInputUI;
    }

    public final void blf() {
        x.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: pwd cancel.finish");
        WalletBalanceFetchPwdInputUI.a(this.oZE).dismiss();
        this.oZE.finish();
    }
}
