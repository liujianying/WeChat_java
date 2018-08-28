package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitBankcardInputUI$5 implements a {
    final /* synthetic */ BankRemitBankcardInputUI mve;
    final /* synthetic */ g mvg;

    BankRemitBankcardInputUI$5(BankRemitBankcardInputUI bankRemitBankcardInputUI, g gVar) {
        this.mve = bankRemitBankcardInputUI;
        this.mvg = gVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[]{Integer.valueOf(this.mvg.mtY.hUm), this.mvg.mtY.hUn});
        BankRemitBankcardInputUI.q(this.mve);
    }
}
