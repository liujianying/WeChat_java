package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitSelectPayeeUI$10 implements a {
    final /* synthetic */ BankRemitSelectPayeeUI mwE;
    final /* synthetic */ f mwF;

    BankRemitSelectPayeeUI$10(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, f fVar) {
        this.mwE = bankRemitSelectPayeeUI;
        this.mwF = fVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[]{Integer.valueOf(this.mwF.mtX.hUm), this.mwF.mtX.hUn});
        if (!bi.oW(this.mwF.mtX.hUn)) {
            Toast.makeText(this.mwE, this.mwF.mtX.hUn, 1).show();
        }
    }
}
