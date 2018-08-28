package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitBankcardInputUI$3 implements a {
    final /* synthetic */ BankRemitBankcardInputUI mve;
    final /* synthetic */ com.tencent.mm.plugin.remittance.bankcard.a.a mvf;

    BankRemitBankcardInputUI$3(BankRemitBankcardInputUI bankRemitBankcardInputUI, com.tencent.mm.plugin.remittance.bankcard.a.a aVar) {
        this.mve = bankRemitBankcardInputUI;
        this.mvf = aVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        BankRemitBankcardInputUI.a(this.mve, this.mvf.mtS.ref);
        BankRemitBankcardInputUI.a(this.mve, new BankcardElemParcel(this.mvf.mtS.ree));
        String str2 = "MicroMsg.BankRemitBankcardInputUI";
        String str3 = "response bank: %s";
        Object[] objArr = new Object[1];
        objArr[0] = BankRemitBankcardInputUI.s(this.mve) != null ? BankRemitBankcardInputUI.s(this.mve).knE : "";
        x.i(str2, str3, objArr);
        BankRemitBankcardInputUI.w(this.mve);
        BankRemitBankcardInputUI.x(this.mve);
        BankRemitBankcardInputUI.y(this.mve);
        BankRemitBankcardInputUI.z(this.mve);
        BankRemitBankcardInputUI.k(this.mve);
    }
}
