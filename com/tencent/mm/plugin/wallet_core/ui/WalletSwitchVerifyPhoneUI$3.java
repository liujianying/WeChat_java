package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.x;

class WalletSwitchVerifyPhoneUI$3 implements a {
    final /* synthetic */ WalletSwitchVerifyPhoneUI pyw;
    final /* synthetic */ fd pyx;

    WalletSwitchVerifyPhoneUI$3(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, fd fdVar) {
        this.pyw = walletSwitchVerifyPhoneUI;
        this.pyx = fdVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
        WalletSwitchVerifyPhoneUI.a(this.pyw, this.pyx);
    }
}
