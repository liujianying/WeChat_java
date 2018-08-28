package com.tencent.mm.plugin.wallet_ecard.ui;

import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.protocal.c.btq;
import com.tencent.mm.wallet_core.ui.e;

class WalletECardLogoutUI$5 implements a {
    final /* synthetic */ btq pCB;
    final /* synthetic */ WalletECardLogoutUI pCz;

    WalletECardLogoutUI$5(WalletECardLogoutUI walletECardLogoutUI, btq btq) {
        this.pCz = walletECardLogoutUI;
        this.pCB = btq;
    }

    public final void aCb() {
        e.l(this.pCz.mController.tml, this.pCB.rvK, false);
    }
}
