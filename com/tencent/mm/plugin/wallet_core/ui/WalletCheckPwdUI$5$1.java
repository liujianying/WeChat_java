package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.5;

class WalletCheckPwdUI$5$1 implements Runnable {
    final /* synthetic */ boolean pvj;
    final /* synthetic */ 5 pvk;

    WalletCheckPwdUI$5$1(5 5, boolean z) {
        this.pvk = 5;
        this.pvj = z;
    }

    public final void run() {
        if (this.pvj) {
            WalletCheckPwdUI.h(this.pvk.pvi).fullScroll(130);
        } else {
            WalletCheckPwdUI.h(this.pvk.pvi).fullScroll(33);
        }
    }
}
