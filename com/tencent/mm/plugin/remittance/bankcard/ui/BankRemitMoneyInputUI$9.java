package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.protocal.c.ck;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class BankRemitMoneyInputUI$9 implements OnClickListener {
    final /* synthetic */ BankRemitMoneyInputUI mwj;
    final /* synthetic */ n mwl;
    final /* synthetic */ ck mwo;

    BankRemitMoneyInputUI$9(BankRemitMoneyInputUI bankRemitMoneyInputUI, n nVar, ck ckVar) {
        this.mwj = bankRemitMoneyInputUI;
        this.mwl = nVar;
        this.mwo = ckVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.mwl.muf.hUm == 0) {
            BankRemitMoneyInputUI.a(this.mwj, this.mwl.muf.kRq, this.mwl.muf.muC, this.mwl.muf.knE, this.mwl.muf.muB);
        } else if (!bi.oW(this.mwo.hUt)) {
            e.l(this.mwj.mController.tml, this.mwo.hUt, false);
        }
    }
}
