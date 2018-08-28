package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ah;

class BankRemitBankcardInputUI$24 implements TextWatcher {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$24(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        BankRemitBankcardInputUI.n(this.mve);
        ah.i(new 1(this), 200);
    }
}
