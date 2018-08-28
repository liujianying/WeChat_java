package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class BankRemitBankcardInputUI$25 implements OnClickListener {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$25(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final void onClick(View view) {
        this.mve.YC();
        String text = BankRemitBankcardInputUI.o(this.mve).getText();
        if (!BankRemitBankcardInputUI.p(this.mve) || bi.oW(text)) {
            BankRemitBankcardInputUI.q(this.mve);
            return;
        }
        BankRemitBankcardInputUI.a(this.mve, text, BankRemitBankcardInputUI.o(this.mve).getMD5Value());
    }
}
