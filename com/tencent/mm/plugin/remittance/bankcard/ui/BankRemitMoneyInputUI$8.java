package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.plugin.wxpay.a.i;

class BankRemitMoneyInputUI$8 implements a {
    final /* synthetic */ BankRemitMoneyInputUI mwj;

    BankRemitMoneyInputUI$8(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        this.mwj = bankRemitMoneyInputUI;
    }

    public final void aCb() {
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(this.mwj, this.mwj.getString(i.bank_remit_remittance_desc_text), BankRemitMoneyInputUI.h(this.mwj), this.mwj.getString(i.remittance_desc_max_words_count_tip), 20, new 1(this), new 2(this));
        h.mEJ.h(14673, new Object[]{Integer.valueOf(4)});
    }
}
