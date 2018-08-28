package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.b;

class BankRemitSelectPayeeUI$4 implements b {
    final /* synthetic */ BankRemitSelectPayeeUI mwE;
    final /* synthetic */ TransferRecordParcel mwG;

    BankRemitSelectPayeeUI$4(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, TransferRecordParcel transferRecordParcel) {
        this.mwE = bankRemitSelectPayeeUI;
        this.mwG = transferRecordParcel;
    }

    public final boolean p(CharSequence charSequence) {
        if (!(this.mwG.muD == null && charSequence == null) && (this.mwG.muD == null || !this.mwG.muD.equals(charSequence))) {
            BankRemitSelectPayeeUI.a(this.mwE, this.mwG.muA, String.valueOf(charSequence));
        } else {
            x.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[]{this.mwG.muD, charSequence});
        }
        return true;
    }
}
