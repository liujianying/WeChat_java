package com.tencent.mm.wallet_core.ui.formview;

import android.text.Editable;
import android.text.TextWatcher;

class WalletFormView$1 implements TextWatcher {
    private boolean mrA = false;
    final /* synthetic */ WalletFormView uZI;

    WalletFormView$1(WalletFormView walletFormView) {
        this.uZI = walletFormView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean ZF = this.uZI.ZF();
        if (!(WalletFormView.h(this.uZI) == null || ZF == this.mrA)) {
            WalletFormView.h(this.uZI).fE(ZF);
            this.mrA = this.uZI.ZF();
        }
        WalletFormView.i(this.uZI);
    }
}
