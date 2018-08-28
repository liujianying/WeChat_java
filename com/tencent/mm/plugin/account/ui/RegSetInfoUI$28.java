package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

class RegSetInfoUI$28 implements TextWatcher {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$28(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final void afterTextChanged(Editable editable) {
        CharSequence trim = RegSetInfoUI.b(this.eWJ).getText().toString().trim();
        if (trim == null || trim.length() <= 16) {
            if (!RegSetInfoUI.m(this.eWJ).ciq()) {
                RegSetInfoUI.m(this.eWJ).SO();
            }
            RegSetInfoUI.n(this.eWJ);
            if (!RegSetInfoUI.o(this.eWJ)) {
                RegSetInfoUI.a(this.eWJ).setText(trim);
                return;
            }
            return;
        }
        RegSetInfoUI.b(this.eWJ).setText(trim.substring(0, 16));
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
