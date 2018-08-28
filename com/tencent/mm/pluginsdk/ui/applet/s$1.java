package com.tencent.mm.pluginsdk.ui.applet;

import android.text.Editable;
import android.text.TextWatcher;

class s$1 implements TextWatcher {
    final /* synthetic */ s qJM;

    s$1(s sVar) {
        this.qJM = sVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        int length = 50 - editable.length();
        if (length < 0) {
            length = 0;
        }
        if (this.qJM.mlc != null) {
            this.qJM.mlc.setText(String.valueOf(length));
        }
    }
}
