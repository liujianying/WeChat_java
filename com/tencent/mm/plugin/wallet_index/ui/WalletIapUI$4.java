package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.g.a.sw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletIapUI$4 extends c<sw> {
    final /* synthetic */ WalletIapUI pDI;

    WalletIapUI$4(WalletIapUI walletIapUI) {
        this.pDI = walletIapUI;
        this.sFo = sw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sw swVar = (sw) bVar;
        x.i("MicroMsg.WalletIapUI", "payListener callback to close progress");
        if (swVar instanceof sw) {
            if (WalletIapUI.c(this.pDI) != null && WalletIapUI.c(this.pDI).isShowing()) {
                WalletIapUI.c(this.pDI).dismiss();
                WalletIapUI.d(this.pDI);
            }
            return true;
        }
        x.f("MicroMsg.WalletIapUI", "mismatched event");
        return false;
    }
}
