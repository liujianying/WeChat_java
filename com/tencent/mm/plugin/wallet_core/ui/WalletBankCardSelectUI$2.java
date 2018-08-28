package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.o.b;

class WalletBankCardSelectUI$2 implements b {
    final /* synthetic */ WalletBankCardSelectUI psM;

    WalletBankCardSelectUI$2(WalletBankCardSelectUI walletBankCardSelectUI) {
        this.psM = walletBankCardSelectUI;
    }

    public final void WX() {
        WalletBankCardSelectUI.a(this.psM, true);
        WalletBankCardSelectUI.a(this.psM).lP(false);
        WalletBankCardSelectUI.a(this.psM).setMode(1);
    }

    public final void WW() {
        WalletBankCardSelectUI.a(this.psM, false);
        this.psM.YC();
        WalletBankCardSelectUI.a(this.psM).lP(true);
        WalletBankCardSelectUI.a(this.psM).setMode(0);
    }

    public final void pk(String str) {
        x.d("WalletBankCardSelectUI", "search text: %s", new Object[]{str});
        WalletBankCardSelectUI.a(this.psM).aac(str);
    }

    public final boolean pj(String str) {
        this.psM.YC();
        return false;
    }

    public final void WY() {
    }

    public final void WZ() {
    }
}
