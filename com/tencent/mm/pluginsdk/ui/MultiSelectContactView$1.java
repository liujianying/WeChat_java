package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;

class MultiSelectContactView$1 implements TextWatcher {
    final /* synthetic */ MultiSelectContactView qGe;

    MultiSelectContactView$1(MultiSelectContactView multiSelectContactView) {
        this.qGe = multiSelectContactView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        MultiSelectContactView.a(this.qGe);
        if (MultiSelectContactView.b(this.qGe) != null) {
            MultiSelectContactView.b(this.qGe).FW(charSequence.toString());
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
