package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.ui.n.b;

class WalletPayCustomUI$1 implements b {
    final /* synthetic */ WalletPayCustomUI pfT;

    WalletPayCustomUI$1(WalletPayCustomUI walletPayCustomUI) {
        this.pfT = walletPayCustomUI;
    }

    public final void c(String str, boolean z, String str2) {
        int i;
        int i2 = WalletPayCustomUI.a(this.pfT).sqz;
        String str3 = WalletPayCustomUI.a(this.pfT).sqy;
        String str4 = WalletPayCustomUI.a(this.pfT).sign;
        String str5 = WalletPayCustomUI.a(this.pfT).hFk;
        String str6 = WalletPayCustomUI.a(this.pfT).rFf;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        this.pfT.a(new w(str, i2, str3, str4, str5, str6, i, str2, ""), true, false);
    }
}
