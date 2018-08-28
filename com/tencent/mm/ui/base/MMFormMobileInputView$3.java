package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bi;

class MMFormMobileInputView$3 implements TextWatcher {
    final /* synthetic */ MMFormMobileInputView tux;

    MMFormMobileInputView$3(MMFormMobileInputView mMFormMobileInputView) {
        this.tux = mMFormMobileInputView;
    }

    public final void afterTextChanged(Editable editable) {
        String obj = MMFormMobileInputView.a(this.tux).getText().toString();
        if (bi.oW(obj)) {
            MMFormMobileInputView.a(this.tux).setText("+");
            MMFormMobileInputView.a(this.tux).setSelection(MMFormMobileInputView.a(this.tux).getText().toString().length());
        } else if (!obj.contains("+")) {
            MMFormMobileInputView.a(this.tux).setText("+" + obj);
            MMFormMobileInputView.a(this.tux).setSelection(MMFormMobileInputView.a(this.tux).getText().toString().length());
        } else if (obj.length() > 1) {
            obj = obj.substring(1);
            if (obj.length() > 4) {
                MMFormMobileInputView.a(this.tux).setText(obj.substring(0, 4));
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
