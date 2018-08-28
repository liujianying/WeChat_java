package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;

class LuckyMoneyMoneyInputView$1 implements TextWatcher {
    final /* synthetic */ LuckyMoneyMoneyInputView kVz;

    LuckyMoneyMoneyInputView$1(LuckyMoneyMoneyInputView luckyMoneyMoneyInputView) {
        this.kVz = luckyMoneyMoneyInputView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (LuckyMoneyMoneyInputView.a(this.kVz) != null) {
            f a = LuckyMoneyMoneyInputView.a(this.kVz);
            this.kVz.getInputViewId();
            a.baD();
        }
    }
}
