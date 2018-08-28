package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

class LoginUI$1 implements TextWatcher {
    final /* synthetic */ LoginUI eSk;

    LoginUI$1(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final void afterTextChanged(Editable editable) {
        LoginUI.a(this.eSk);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
