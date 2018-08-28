package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

class RegByMobileRegAIOUI$22 implements TextWatcher {
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$22(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.eVb = regByMobileRegAIOUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        RegByMobileRegAIOUI.b(this.eVb);
    }
}
