package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h$a;

class BankRemitSelectPayeeUI$7 implements h$a {
    final /* synthetic */ BankRemitSelectPayeeUI mwE;
    final /* synthetic */ j mwI;

    BankRemitSelectPayeeUI$7(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, j jVar) {
        this.mwE = bankRemitSelectPayeeUI;
        this.mwI = jVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[]{Integer.valueOf(this.mwI.mub.hUm), this.mwI.mub.hUn});
        if (!bi.oW(this.mwI.mub.hUn)) {
            Toast.makeText(this.mwE, this.mwI.mub.hUn, 1).show();
        }
    }
}
