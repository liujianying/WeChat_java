package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.a.a;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtSaveFetchUI$9 implements a {
    final /* synthetic */ WalletLqtSaveFetchUI pcc;
    final /* synthetic */ int pch;

    WalletLqtSaveFetchUI$9(WalletLqtSaveFetchUI walletLqtSaveFetchUI, int i) {
        this.pcc = walletLqtSaveFetchUI;
        this.pch = i;
    }

    public final void We() {
        WalletLqtSaveFetchUI.c(this.pcc).setText(e.A(WalletLqtSaveFetchUI.fa(this.pch, "100")));
    }
}
