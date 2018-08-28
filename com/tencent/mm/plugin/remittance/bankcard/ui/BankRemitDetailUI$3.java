package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class BankRemitDetailUI$3 implements a {
    final /* synthetic */ BankRemitDetailUI mvD;

    BankRemitDetailUI$3(BankRemitDetailUI bankRemitDetailUI) {
        this.mvD = bankRemitDetailUI;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.BankRemitDetailUI", "net error: %s", new Object[]{lVar});
        Toast.makeText(this.mvD, a$i.bank_remit_detail_fetch_fail_text, 1).show();
    }
}
