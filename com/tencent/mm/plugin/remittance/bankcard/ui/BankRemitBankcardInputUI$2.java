package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h$a;

class BankRemitBankcardInputUI$2 implements h$a {
    final /* synthetic */ BankRemitBankcardInputUI mve;
    final /* synthetic */ a mvf;

    BankRemitBankcardInputUI$2(BankRemitBankcardInputUI bankRemitBankcardInputUI, a aVar) {
        this.mve = bankRemitBankcardInputUI;
        this.mvf = aVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[]{Integer.valueOf(this.mvf.mtS.hUm), this.mvf.mtS.hUn});
        if (!bi.oW(this.mvf.mtS.hUn)) {
            Toast.makeText(this.mve, this.mvf.mtS.hUn, 1).show();
        }
    }
}
