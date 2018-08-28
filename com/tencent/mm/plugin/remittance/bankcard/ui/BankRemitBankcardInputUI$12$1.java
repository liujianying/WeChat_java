package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.12;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class BankRemitBankcardInputUI$12$1 implements c {
    final /* synthetic */ 12 mvj;

    BankRemitBankcardInputUI$12$1(12 12) {
        this.mvj = 12;
    }

    public final void a(l lVar) {
        lVar.add(0, 0, 0, this.mvj.mve.getString(i.bank_remit_history_title));
        lVar.add(0, 1, 0, this.mvj.mve.getString(i.bank_remit_help_center_text));
    }
}
