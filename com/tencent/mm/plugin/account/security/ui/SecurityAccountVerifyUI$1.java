package com.tencent.mm.plugin.account.security.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bi;

class SecurityAccountVerifyUI$1 implements TextWatcher {
    final /* synthetic */ SecurityAccountVerifyUI ePi;

    SecurityAccountVerifyUI$1(SecurityAccountVerifyUI securityAccountVerifyUI) {
        this.ePi = securityAccountVerifyUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean z = (editable == null || bi.oW(editable.toString())) ? false : true;
        this.ePi.enableOptionMenu(z);
    }
}
