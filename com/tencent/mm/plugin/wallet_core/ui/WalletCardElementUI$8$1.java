package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.8;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

class WalletCardElementUI$8$1 implements a {
    final /* synthetic */ b gQT;
    final /* synthetic */ 8 puo;

    WalletCardElementUI$8$1(8 8, b bVar) {
        this.puo = 8;
        this.gQT = bVar;
    }

    public final void h(boolean z, Object obj) {
        this.gQT.hide();
        if (z) {
            Object obj2;
            String str = (String) obj;
            WalletCardElementUI.g(this.puo.pun).setText(str);
            if (str.equals(this.puo.pun.getString(i.wallet_credit_card))) {
                obj2 = null;
            } else {
                int obj22 = 1;
            }
            for (ElementQuery elementQuery : WalletCardElementUI.e(this.puo.pun)) {
                if ((obj22 != null && elementQuery.bOE()) || (obj22 == null && elementQuery.bOu())) {
                    WalletCardElementUI.a(this.puo.pun, elementQuery);
                    WalletCardElementUI.h(this.puo.pun);
                    break;
                }
            }
        }
        WalletCardElementUI.a(this.puo.pun, this.gQT.cAP());
    }
}
