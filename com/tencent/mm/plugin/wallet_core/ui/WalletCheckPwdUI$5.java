package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.a;

class WalletCheckPwdUI$5 implements a {
    final /* synthetic */ WalletCheckPwdUI pvi;

    WalletCheckPwdUI$5(WalletCheckPwdUI walletCheckPwdUI) {
        this.pvi = walletCheckPwdUI;
    }

    public final void fI(boolean z) {
        x.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[]{Boolean.valueOf(z)});
        WalletCheckPwdUI.h(this.pvi).post(new 1(this, z));
    }
}
