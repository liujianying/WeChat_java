package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.ScrollView;
import com.tencent.mm.wallet_core.ui.a;

class WalletPwdConfirmUI$4 implements a {
    final /* synthetic */ WalletPwdConfirmUI pxf;
    final /* synthetic */ ScrollView pxg;

    WalletPwdConfirmUI$4(WalletPwdConfirmUI walletPwdConfirmUI, ScrollView scrollView) {
        this.pxf = walletPwdConfirmUI;
        this.pxg = scrollView;
    }

    public final void fI(boolean z) {
        if (z) {
            WalletPwdConfirmUI.a(this.pxf, this.pxg, WalletPwdConfirmUI.b(this.pxf));
        } else {
            this.pxg.scrollTo(0, 0);
        }
    }
}
