package com.tencent.mm.ui;

import android.text.Editable;
import android.text.TextWatcher;

class ag$3 implements TextWatcher {
    final /* synthetic */ ag tpY;

    ag$3(ag agVar) {
        this.tpY = agVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() <= 0) {
            ag.c(this.tpY).setVisibility(8);
        } else {
            ag.c(this.tpY).setVisibility(0);
        }
    }
}
