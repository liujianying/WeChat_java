package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.2;

class WalletVerifyIdCardUI$2$1 implements Runnable {
    final /* synthetic */ boolean pyZ;
    final /* synthetic */ 2 pza;

    WalletVerifyIdCardUI$2$1(2 2, boolean z) {
        this.pza = 2;
        this.pyZ = z;
    }

    public final void run() {
        if (this.pyZ && !WalletVerifyIdCardUI.a(this.pza.pyY, WalletVerifyIdCardUI.a(this.pza.pyY))) {
            WalletVerifyIdCardUI.b(this.pza.pyY);
        }
    }
}
