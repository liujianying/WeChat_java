package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.c;

class WalletChangeBankcardUI$5 implements c {
    final /* synthetic */ WalletChangeBankcardUI pfC;

    WalletChangeBankcardUI$5(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.pfC = walletChangeBankcardUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        this.pfC.pfz = favorPayInfo;
        this.pfC.sy.putParcelable("key_favor_pay_info", this.pfC.pfz);
        if (this.pfC.pfz == null || !z) {
            this.pfC.eWo = str;
            this.pfC.YC();
            this.pfC.OQ(str);
            this.pfC.pfB = null;
            return;
        }
        if (this.pfC.pfz != null) {
            this.pfC.jm(true);
            this.pfC.pfx.e(this.pfC.oZG, false);
        }
        if (this.pfC.oZD != null) {
            this.pfC.oZD.dismiss();
        }
        this.pfC.aL();
        this.pfC.ux(0);
    }
}
