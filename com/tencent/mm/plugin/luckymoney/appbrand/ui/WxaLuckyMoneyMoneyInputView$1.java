package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.luckymoney.ui.f;

class WxaLuckyMoneyMoneyInputView$1 implements TextWatcher {
    final /* synthetic */ WxaLuckyMoneyMoneyInputView kLy;

    WxaLuckyMoneyMoneyInputView$1(WxaLuckyMoneyMoneyInputView wxaLuckyMoneyMoneyInputView) {
        this.kLy = wxaLuckyMoneyMoneyInputView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (WxaLuckyMoneyMoneyInputView.a(this.kLy) != null) {
            f a = WxaLuckyMoneyMoneyInputView.a(this.kLy);
            this.kLy.getInputViewId();
            a.baD();
        }
    }
}
