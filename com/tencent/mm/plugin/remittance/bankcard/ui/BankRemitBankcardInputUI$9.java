package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.m;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h$a;

class BankRemitBankcardInputUI$9 implements h$a {
    final /* synthetic */ BankRemitBankcardInputUI mve;
    final /* synthetic */ m mvh;

    BankRemitBankcardInputUI$9(BankRemitBankcardInputUI bankRemitBankcardInputUI, m mVar) {
        this.mve = bankRemitBankcardInputUI;
        this.mvh = mVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        BankRemitBankcardInputUI.b(this.mve, false);
        BankRemitBankcardInputUI.b(this.mve, this.mvh.mue.rec);
        x.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[]{BankRemitBankcardInputUI.A(this.mve)});
        BankRemitBankcardInputUI.a(this.mve, TransferRecordParcel.bT(this.mvh.mue.sgc));
        BankRemitBankcardInputUI.b(this.mve, TransferRecordParcel.bT(this.mvh.mue.sgb));
        x.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[]{Integer.valueOf(BankRemitBankcardInputUI.B(this.mve).size()), Integer.valueOf(BankRemitBankcardInputUI.C(this.mve).size())});
        BankRemitBankcardInputUI.D(this.mve);
    }
}
