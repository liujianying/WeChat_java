package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

class LoginPasswordUI$3 implements TextWatcher {
    final /* synthetic */ LoginPasswordUI eRO;

    LoginPasswordUI$3(LoginPasswordUI loginPasswordUI) {
        this.eRO = loginPasswordUI;
    }

    public final void afterTextChanged(Editable editable) {
        if (this.eRO.eQO.getText().toString().length() > 0) {
            this.eRO.eQP.setEnabled(true);
        } else {
            this.eRO.eQP.setEnabled(false);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
