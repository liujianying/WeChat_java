package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;

class MMAutoCompleteTextView$2 implements TextWatcher {
    final /* synthetic */ MMAutoCompleteTextView ttE;

    MMAutoCompleteTextView$2(MMAutoCompleteTextView mMAutoCompleteTextView) {
        this.ttE = mMAutoCompleteTextView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        MMAutoCompleteTextView.b(this.ttE);
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
