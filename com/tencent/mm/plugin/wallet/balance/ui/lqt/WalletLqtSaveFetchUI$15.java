package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.vending.c.a;
import java.util.List;

class WalletLqtSaveFetchUI$15 implements a<Void, Void> {
    final /* synthetic */ WalletLqtSaveFetchUI pcc;
    final /* synthetic */ List pcn;

    WalletLqtSaveFetchUI$15(WalletLqtSaveFetchUI walletLqtSaveFetchUI, List list) {
        this.pcc = walletLqtSaveFetchUI;
        this.pcn = list;
    }

    public final /* synthetic */ Object call(Object obj) {
        for (Bankcard bankcard : WalletLqtSaveFetchUI.j(this.pcc)) {
            Object obj2;
            for (Bankcard bankcard2 : this.pcn) {
                if (bankcard.field_bindSerial.equals(bankcard2.field_bindSerial)) {
                    obj2 = 1;
                    continue;
                    break;
                }
            }
            obj2 = null;
            continue;
            if (obj2 == null) {
                WalletLqtSaveFetchUI.a(this.pcc, bankcard.field_bindSerial);
                break;
            }
        }
        WalletLqtSaveFetchUI.h(this.pcc);
        return uQG;
    }
}
