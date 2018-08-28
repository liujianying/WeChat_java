package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletCheckIdentityUI$1 implements OnClickListener {
    final /* synthetic */ WalletCheckIdentityUI qwO;

    WalletCheckIdentityUI$1(WalletCheckIdentityUI walletCheckIdentityUI) {
        this.qwO = walletCheckIdentityUI;
    }

    public final void onClick(View view) {
        if (WalletCheckIdentityUI.a(this.qwO, WalletCheckIdentityUI.a(this.qwO).getText(), WalletCheckIdentityUI.b(this.qwO).getText())) {
            this.qwO.cDL().m(new Object[]{r0, r1});
        }
    }
}
