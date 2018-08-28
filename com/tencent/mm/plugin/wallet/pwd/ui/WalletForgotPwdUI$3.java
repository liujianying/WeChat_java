package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.wallet_core.ui.e;

class WalletForgotPwdUI$3 implements OnClickListener {
    final /* synthetic */ WalletForgotPwdUI phK;

    WalletForgotPwdUI$3(WalletForgotPwdUI walletForgotPwdUI) {
        this.phK = walletForgotPwdUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11353, Integer.valueOf(2), Integer.valueOf(0));
        WalletForgotPwdUI walletForgotPwdUI = this.phK;
        p.bNp();
        e.e(walletForgotPwdUI, p.bNq().aCl());
    }
}
