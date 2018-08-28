package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitSelectPayeeUI$8 implements a {
    final /* synthetic */ BankRemitSelectPayeeUI mwE;
    final /* synthetic */ j mwI;

    BankRemitSelectPayeeUI$8(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, j jVar) {
        this.mwE = bankRemitSelectPayeeUI;
        this.mwI = jVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
        BankRemitSelectPayeeUI.b(this.mwE, this.mwI.mtT, this.mwI.fky);
    }
}
