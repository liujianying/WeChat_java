package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bi;

class MobileVerifyUI$7 implements TextWatcher {
    final /* synthetic */ MobileVerifyUI eUo;

    MobileVerifyUI$7(MobileVerifyUI mobileVerifyUI) {
        this.eUo = mobileVerifyUI;
    }

    public final void afterTextChanged(Editable editable) {
        if (bi.oW(this.eUo.eGC.getText().toString())) {
            this.eUo.eGC.setTextSize(15.0f);
            this.eUo.eGC.setGravity(16);
        } else {
            this.eUo.eGC.setTextSize(24.0f);
            this.eUo.eGC.setGravity(16);
        }
        if (this.eUo.eGC.getText() == null || this.eUo.eGC.getText().toString().length() <= 0) {
            this.eUo.eUb.setEnabled(false);
        } else {
            this.eUo.eUb.setEnabled(true);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
