package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

class SimpleLoginUI$1 implements TextWatcher {
    final /* synthetic */ SimpleLoginUI eXn;

    SimpleLoginUI$1(SimpleLoginUI simpleLoginUI) {
        this.eXn = simpleLoginUI;
    }

    public final void afterTextChanged(Editable editable) {
        SimpleLoginUI.a(this.eXn);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
