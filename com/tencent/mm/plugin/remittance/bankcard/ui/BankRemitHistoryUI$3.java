package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitHistoryUI$3 implements a {
    final /* synthetic */ BankRemitHistoryUI mvI;

    BankRemitHistoryUI$3(BankRemitHistoryUI bankRemitHistoryUI) {
        this.mvI = bankRemitHistoryUI;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[]{lVar});
    }
}
