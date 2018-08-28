package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Comparator;

class WalletChangeBankcardUI$2 implements Comparator<Bankcard> {
    final /* synthetic */ WalletChangeBankcardUI pfC;

    WalletChangeBankcardUI$2(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.pfC = walletChangeBankcardUI;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Bankcard bankcard = (Bankcard) obj;
        Bankcard bankcard2 = (Bankcard) obj2;
        if (bankcard.bOs()) {
            return -1;
        }
        if (bankcard.bOt()) {
            return bankcard2.bOs() ? 1 : -1;
        } else {
            if (bi.WJ(bankcard.field_forbidWord) >= bi.WJ(bankcard2.field_forbidWord)) {
                return bi.WJ(bankcard.field_forbidWord) > bi.WJ(bankcard2.field_forbidWord) ? 1 : 0;
            } else {
                return -1;
            }
        }
    }
}
