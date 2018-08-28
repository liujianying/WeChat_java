package com.tencent.mm.plugin.recharge.ui.form;

import android.text.Editable;
import android.text.TextWatcher;

class MallFormView$1 implements TextWatcher {
    private boolean mrA = false;
    final /* synthetic */ MallFormView mrB;

    MallFormView$1(MallFormView mallFormView) {
        this.mrB = mallFormView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.mrB.ZF() != this.mrA) {
            if (MallFormView.c(this.mrB) != null) {
                MallFormView.c(this.mrB).fE(this.mrB.ZF());
            }
            this.mrA = this.mrB.ZF();
        }
        this.mrB.bql();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
