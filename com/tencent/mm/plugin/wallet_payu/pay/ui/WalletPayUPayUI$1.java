package com.tencent.mm.plugin.wallet_payu.pay.ui;

import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;

class WalletPayUPayUI$1 implements b {
    final /* synthetic */ WalletPayUPayUI pFA;

    WalletPayUPayUI$1(WalletPayUPayUI walletPayUPayUI) {
        this.pFA = walletPayUPayUI;
    }

    public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
        this.pFA.YC();
        WalletPayUPayUI.a(this.pFA, str);
        WalletPayUPayUI.b(this.pFA, str2);
        this.pFA.jp(false);
        c.bQW();
    }
}
