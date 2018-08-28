package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class WalletLqtSimpleCheckPwdUI$2 implements a {
    final /* synthetic */ WalletLqtSimpleCheckPwdUI pcp;

    WalletLqtSimpleCheckPwdUI$2(WalletLqtSimpleCheckPwdUI walletLqtSimpleCheckPwdUI) {
        this.pcp = walletLqtSimpleCheckPwdUI;
    }

    public final void fE(boolean z) {
        if (z) {
            WalletLqtSimpleCheckPwdUI.a(this.pcp, new r(WalletLqtSimpleCheckPwdUI.a(this.pcp).getText(), 7, this.pcp.bNs()));
            this.pcp.a(WalletLqtSimpleCheckPwdUI.b(this.pcp), true, false);
        }
    }
}
