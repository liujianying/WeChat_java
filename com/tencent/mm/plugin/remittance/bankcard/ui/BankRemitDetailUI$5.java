package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitDetailUI$5 implements a {
    final /* synthetic */ BankRemitDetailUI mvD;
    final /* synthetic */ l mvE;

    BankRemitDetailUI$5(BankRemitDetailUI bankRemitDetailUI, l lVar) {
        this.mvD = bankRemitDetailUI;
        this.mvE = lVar;
    }

    public final void g(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[]{Integer.valueOf(this.mvE.mud.state), Integer.valueOf(this.mvE.mud.amount), Integer.valueOf(this.mvE.mud.sfV), this.mvE.mud.sfW});
        BankRemitDetailUI.a(this.mvD, this.mvE.mud.state);
        BankRemitDetailUI.a(this.mvD, this.mvE.mud.state, this.mvE.mud.sfU);
        BankRemitDetailUI.a(this.mvD, this.mvE.mud);
        BankRemitDetailUI.a(this.mvD).setVisibility(0);
    }
}
