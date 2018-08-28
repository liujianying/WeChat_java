package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Filter.FilterListener;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitBankcardInputUI$19 implements FilterListener {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$19(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final void onFilterComplete(int i) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "filter complete: %d", new Object[]{Integer.valueOf(i)});
        if (BankRemitBankcardInputUI.f(this.mve) == null) {
            return;
        }
        if (i > 0 && !BankRemitBankcardInputUI.f(this.mve).PK.isShowing()) {
            BankRemitBankcardInputUI.f(this.mve).show();
        } else if (i <= 0 && BankRemitBankcardInputUI.f(this.mve).PK.isShowing()) {
            BankRemitBankcardInputUI.f(this.mve).dismiss();
        }
    }
}
