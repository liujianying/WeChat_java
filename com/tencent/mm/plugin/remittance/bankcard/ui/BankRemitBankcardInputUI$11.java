package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitBankcardInputUI$11 implements a {
    final /* synthetic */ BankRemitBankcardInputUI mve;
    final /* synthetic */ d mvi;

    BankRemitBankcardInputUI$11(BankRemitBankcardInputUI bankRemitBankcardInputUI, d dVar) {
        this.mve = bankRemitBankcardInputUI;
        this.mvi = dVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[]{Integer.valueOf(this.mvi.mtV.hUm), this.mvi.mtV.hUn});
        if (!bi.oW(this.mvi.mtV.hUn)) {
            Toast.makeText(this.mve, this.mvi.mtV.hUn, 1).show();
        }
    }
}
