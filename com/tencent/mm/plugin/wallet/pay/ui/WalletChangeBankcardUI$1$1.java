package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.g.a.tk;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.1;

class WalletChangeBankcardUI$1$1 implements Runnable {
    final /* synthetic */ tk pfD;
    final /* synthetic */ 1 pfE;

    WalletChangeBankcardUI$1$1(1 1, tk tkVar) {
        this.pfE = 1;
        this.pfD = tkVar;
    }

    public final void run() {
        if (-1 == this.pfD.ceX.result) {
            this.pfE.pfC.bNy();
        }
    }
}
