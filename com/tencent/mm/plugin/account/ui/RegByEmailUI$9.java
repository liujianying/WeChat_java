package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

class RegByEmailUI$9 implements TextWatcher {
    final /* synthetic */ RegByEmailUI eUG;

    RegByEmailUI$9(RegByEmailUI regByEmailUI) {
        this.eUG = regByEmailUI;
    }

    public final void afterTextChanged(Editable editable) {
        RegByEmailUI.b(this.eUG);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
