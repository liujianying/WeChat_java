package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.u;

class BankRemitBankcardInputUI$27 extends u {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$27(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final void aBU() {
        x.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
        this.mve.YC();
        this.mve.Wq();
        if (!BankRemitBankcardInputUI.r(this.mve)) {
            String text = BankRemitBankcardInputUI.u(this.mve).getText();
            String text2 = BankRemitBankcardInputUI.o(this.mve).getText();
            if (bi.oW(text) || text.trim().isEmpty() || bi.oW(text2) || text2.trim().isEmpty() || BankRemitBankcardInputUI.s(this.mve) == null) {
                x.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[]{text, text2, BankRemitBankcardInputUI.s(this.mve)});
            } else if (BankRemitBankcardInputUI.i(this.mve)) {
                x.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
                BankRemitBankcardInputUI.v(this.mve);
            } else {
                BankRemitBankcardInputUI.a(this.mve, text, text2, BankRemitBankcardInputUI.s(this.mve).knE, BankRemitBankcardInputUI.s(this.mve).lMV);
            }
        }
    }
}
