package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitBankcardInputUI$6 implements a {
    final /* synthetic */ BankRemitBankcardInputUI mve;
    final /* synthetic */ g mvg;

    BankRemitBankcardInputUI$6(BankRemitBankcardInputUI bankRemitBankcardInputUI, g gVar) {
        this.mve = bankRemitBankcardInputUI;
        this.mvg = gVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        if (this.mvg.mtY.ree == null) {
            x.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
            BankRemitBankcardInputUI.q(this.mve);
            return;
        }
        BankRemitBankcardInputUI.a(this.mve, new BankcardElemParcel(this.mvg.mtY.ree));
        BankRemitBankcardInputUI.w(this.mve);
        BankRemitBankcardInputUI.x(this.mve);
        BankRemitBankcardInputUI.y(this.mve);
        BankRemitBankcardInputUI.z(this.mve);
        BankRemitBankcardInputUI.k(this.mve);
    }
}
