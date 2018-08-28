package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.8;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h.b;

class BankRemitMoneyInputUI$8$1 implements b {
    final /* synthetic */ 8 mwm;

    BankRemitMoneyInputUI$8$1(8 8) {
        this.mwm = 8;
    }

    public final boolean p(CharSequence charSequence) {
        if (bi.oW(charSequence.toString())) {
            BankRemitMoneyInputUI.c(this.mwm.mwj, null);
            BankRemitMoneyInputUI.i(this.mwm.mwj);
        } else {
            BankRemitMoneyInputUI.c(this.mwm.mwj, charSequence.toString());
            BankRemitMoneyInputUI.i(this.mwm.mwj);
        }
        return true;
    }
}
