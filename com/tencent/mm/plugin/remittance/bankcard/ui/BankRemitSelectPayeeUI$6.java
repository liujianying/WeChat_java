package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitSelectPayeeUI$6 implements a {
    final /* synthetic */ BankRemitSelectPayeeUI mwE;

    BankRemitSelectPayeeUI$6(BankRemitSelectPayeeUI bankRemitSelectPayeeUI) {
        this.mwE = bankRemitSelectPayeeUI;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[]{lVar});
    }
}
