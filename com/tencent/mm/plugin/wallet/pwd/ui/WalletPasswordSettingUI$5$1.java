package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.g.a.bq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.5;
import com.tencent.mm.plugin.wallet_core.c.y;

class WalletPasswordSettingUI$5$1 implements Runnable {
    final /* synthetic */ bq jgn;
    final /* synthetic */ 5 pih;

    WalletPasswordSettingUI$5$1(5 5, bq bqVar) {
        this.pih = 5;
        this.jgn = bqVar;
    }

    public final void run() {
        if (this.jgn.bJb == null) {
            return;
        }
        if (this.jgn.bJb.retCode == 0) {
            WalletPasswordSettingUI.d(this.pih.pif);
            g.Ek();
            g.Eh().dpP.a(new y(null, 19), 0);
            return;
        }
        WalletPasswordSettingUI.e(this.pih.pif);
        WalletPasswordSettingUI.f(this.pih.pif);
    }
}
