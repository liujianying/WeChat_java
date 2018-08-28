package com.tencent.mm.plugin.wallet_payu.pay.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;

class WalletPayUChangeBankcardUI$1 implements b {
    final /* synthetic */ WalletPayUChangeBankcardUI pFy;

    WalletPayUChangeBankcardUI$1(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        this.pFy = walletPayUChangeBankcardUI;
    }

    public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
        WalletPayUChangeBankcardUI.a(this.pFy, favorPayInfo);
        this.pFy.sy.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(this.pFy));
        WalletPayUChangeBankcardUI.a(this.pFy, str);
        WalletPayUChangeBankcardUI.b(this.pFy, str2);
        this.pFy.YC();
        this.pFy.OQ(str);
    }
}
