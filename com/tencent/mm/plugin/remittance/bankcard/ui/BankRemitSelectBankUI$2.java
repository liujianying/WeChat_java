package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitSelectBankUI$2 implements a {
    final /* synthetic */ BankRemitSelectBankUI mwu;
    final /* synthetic */ h mwv;

    BankRemitSelectBankUI$2(BankRemitSelectBankUI bankRemitSelectBankUI, h hVar) {
        this.mwu = bankRemitSelectBankUI;
        this.mwv = hVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitSelectBankUI", "net error: %s", new Object[]{this.mwv});
    }
}
