package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitBankcardInputUI$15 implements a {
    final /* synthetic */ BankRemitBankcardInputUI mve;
    final /* synthetic */ k mvk;

    BankRemitBankcardInputUI$15(BankRemitBankcardInputUI bankRemitBankcardInputUI, k kVar) {
        this.mve = bankRemitBankcardInputUI;
        this.mvk = kVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[]{Integer.valueOf(this.mvk.muc.hUm), this.mvk.muc.hUn});
        if (!bi.oW(this.mvk.muc.hUn)) {
            Toast.makeText(this.mve, this.mvk.muc.hUn, 1).show();
        }
        this.mve.finish();
    }
}
