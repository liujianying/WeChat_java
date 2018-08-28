package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.7;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.vending.g.d.a;

class WalletLqtSaveFetchUI$7$3 implements a {
    final /* synthetic */ 7 pcf;

    WalletLqtSaveFetchUI$7$3(7 7) {
        this.pcf = 7;
    }

    public final void bd(Object obj) {
        this.pcf.pcc.bNd();
        if (obj != null) {
            String obj2;
            if (obj instanceof String) {
                obj2 = obj.toString();
            } else {
                obj2 = this.pcf.pcc.getString(i.wallet_lqt_network_error);
            }
            this.pcf.pcc.Kk(obj2);
        }
    }
}
