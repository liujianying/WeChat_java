package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h$a;

class BankRemitSelectBankUI$3 implements h$a {
    final /* synthetic */ BankRemitSelectBankUI mwu;
    final /* synthetic */ h mwv;

    BankRemitSelectBankUI$3(BankRemitSelectBankUI bankRemitSelectBankUI, h hVar) {
        this.mwu = bankRemitSelectBankUI;
        this.mwv = hVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", new Object[]{Integer.valueOf(this.mwv.mtZ.hUm), this.mwv.mtZ.hUn});
        if (!bi.oW(this.mwv.mtZ.hUn)) {
            Toast.makeText(this.mwu, this.mwv.mtZ.hUn, 1).show();
        }
    }
}
