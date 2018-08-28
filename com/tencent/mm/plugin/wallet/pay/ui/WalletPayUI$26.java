package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.ui.u;

class WalletPayUI$26 extends u {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$26(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void aBU() {
        p.bNp();
        if (!p.bNq().bPt()) {
            com.tencent.mm.wallet_core.c.u.d(this.pgT.mCn == null ? 0 : this.pgT.mCn.bVY, this.pgT.mCn == null ? "" : this.pgT.mCn.bOd, 6, "");
        }
        this.pgT.bNQ();
    }
}
