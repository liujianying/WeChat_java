package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.g.a.sw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WalletBrandUI$3 extends c<sw> {
    final /* synthetic */ WalletBrandUI pDC;

    WalletBrandUI$3(WalletBrandUI walletBrandUI) {
        this.pDC = walletBrandUI;
        this.sFo = sw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (WalletBrandUI.a(this.pDC) != null) {
            WalletBrandUI.a(this.pDC).dismiss();
            WalletBrandUI.b(this.pDC);
        }
        return true;
    }
}
