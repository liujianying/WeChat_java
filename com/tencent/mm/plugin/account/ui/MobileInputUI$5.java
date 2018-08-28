package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;

class MobileInputUI$5 implements TextWatcher {
    final /* synthetic */ MobileInputUI eTe;

    MobileInputUI$5(MobileInputUI mobileInputUI) {
        this.eTe = mobileInputUI;
    }

    public final void afterTextChanged(Editable editable) {
        this.eTe.eSS.setEnabled(MobileInputUI.f(this.eTe));
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
