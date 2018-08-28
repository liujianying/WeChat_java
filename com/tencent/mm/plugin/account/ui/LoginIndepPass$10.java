package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

class LoginIndepPass$10 implements TextWatcher {
    final /* synthetic */ LoginIndepPass eRJ;

    LoginIndepPass$10(LoginIndepPass loginIndepPass) {
        this.eRJ = loginIndepPass;
    }

    public final void afterTextChanged(Editable editable) {
        LoginIndepPass.b(this.eRJ);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
