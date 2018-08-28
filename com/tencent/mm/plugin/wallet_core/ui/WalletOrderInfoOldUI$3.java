package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.am;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class WalletOrderInfoOldUI$3 extends c<am> {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    WalletOrderInfoOldUI$3(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
        this.sFo = am.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        am amVar = (am) bVar;
        if (amVar instanceof am) {
            this.pwD.pwv = amVar.bHP.bHR;
            this.pwD.bHS = amVar.bHP.bHS;
            this.pwD.bHT = amVar.bHP.bHT;
            this.pwD.bHU = amVar.bHP.bHU;
            if (this.pwD.bHU && !bi.oW(this.pwD.ptj)) {
                for (int i = 0; i < this.pwD.pvL.size(); i++) {
                    int i2;
                    Commodity commodity = (Commodity) this.pwD.pvL.get(i);
                    int i3 = -1;
                    int i4 = 0;
                    while (true) {
                        i2 = i3;
                        if (i4 >= commodity.ppF.size()) {
                            break;
                        }
                        Promotions promotions = (Promotions) commodity.ppF.get(i4);
                        if (promotions.type == Orders.ppv && !bi.oW(promotions.url) && promotions.url.equals(this.pwD.ptj)) {
                            i2 = i4;
                        }
                        i3 = i4 + 1;
                    }
                    if (i2 >= 0) {
                        commodity.ppF.remove(i2);
                    }
                }
            }
            this.pwD.pwu.notifyDataSetChanged();
            if (!bi.oW(this.pwD.ptj)) {
                TextView textView = (TextView) this.pwD.pww.get(this.pwD.ptj);
                if (textView != null) {
                    textView.setClickable(this.pwD.bHS);
                    textView.setEnabled(this.pwD.bHS);
                    textView.setOnClickListener(null);
                    if (this.pwD.bHT) {
                        textView.setVisibility(8);
                    }
                }
            }
            amVar.bHQ.bGZ = true;
        }
        return false;
    }
}
