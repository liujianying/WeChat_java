package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;

class BankRemitBankcardInputUI$22 implements TextWatcher {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$22(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        BankRemitBankcardInputUI.c(this.mve);
        BankRemitBankcardInputUI.d(this.mve);
        if (!BankRemitBankcardInputUI.e(this.mve) || BankRemitBankcardInputUI.f(this.mve) == null) {
            BankRemitBankcardInputUI.a(this.mve, true);
        } else {
            BankRemitBankcardInputUI.h(this.mve).getFilter().filter(editable.toString(), BankRemitBankcardInputUI.g(this.mve));
        }
        if (BankRemitBankcardInputUI.i(this.mve)) {
            BankRemitBankcardInputUI.j(this.mve);
        }
        BankRemitBankcardInputUI.k(this.mve);
        BankRemitBankcardInputUI.l(this.mve);
    }
}
