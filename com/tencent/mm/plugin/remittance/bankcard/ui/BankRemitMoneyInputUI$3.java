package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.remittance.bankcard.model.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.u;

class BankRemitMoneyInputUI$3 extends u {
    final /* synthetic */ BankRemitMoneyInputUI mwj;

    BankRemitMoneyInputUI$3(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        this.mwj = bankRemitMoneyInputUI;
    }

    public final void aBU() {
        x.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
        double em = a.em(BankRemitMoneyInputUI.c(this.mwj).getText(), "100");
        if (em <= 0.0d) {
            x.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[]{Double.valueOf(em)});
            Toast.makeText(this.mwj, i.bank_remit_illegal_arg_text, 1).show();
        } else if (em > ((double) BankRemitMoneyInputUI.d(this.mwj))) {
            x.w("MicroMsg.BankRemitMoneyInputUI", "more than max: %s", new Object[]{Double.valueOf(em)});
            Toast.makeText(this.mwj, this.mwj.getString(i.bank_remit_max_money_toast, new Object[]{a.el(BankRemitMoneyInputUI.d(this.mwj), "100")}), 0).show();
        } else {
            BankRemitMoneyInputUI.e(this.mwj);
        }
    }
}
