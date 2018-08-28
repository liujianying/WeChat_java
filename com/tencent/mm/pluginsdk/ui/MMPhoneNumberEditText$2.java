package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bi;

class MMPhoneNumberEditText$2 implements TextWatcher {
    final /* synthetic */ MMPhoneNumberEditText qFR;

    MMPhoneNumberEditText$2(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.qFR = mMPhoneNumberEditText;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        MMPhoneNumberEditText.c(this.qFR);
        if (!charSequence.toString().equals("") || MMPhoneNumberEditText.d(this.qFR)) {
            if (charSequence.toString().equals("") || !MMPhoneNumberEditText.d(this.qFR)) {
                if (MMPhoneNumberEditText.b(this.qFR) != null && this.qFR.isFocused()) {
                    MMPhoneNumberEditText.b(this.qFR).cdm();
                }
            } else if (MMPhoneNumberEditText.b(this.qFR) != null && this.qFR.isFocused()) {
                MMPhoneNumberEditText.b(this.qFR).cdl();
            }
        } else if (MMPhoneNumberEditText.b(this.qFR) != null && this.qFR.isFocused()) {
            MMPhoneNumberEditText.b(this.qFR).g(this.qFR);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (bi.oW(charSequence.toString())) {
            MMPhoneNumberEditText.a(this.qFR, true);
        } else {
            MMPhoneNumberEditText.a(this.qFR, false);
        }
    }
}
