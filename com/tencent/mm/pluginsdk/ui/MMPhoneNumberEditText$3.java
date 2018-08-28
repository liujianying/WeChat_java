package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMPhoneNumberEditText$3 implements OnFocusChangeListener {
    final /* synthetic */ MMPhoneNumberEditText qFR;

    MMPhoneNumberEditText$3(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.qFR = mMPhoneNumberEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        if (MMPhoneNumberEditText.e(this.qFR) != null) {
            MMPhoneNumberEditText.e(this.qFR).onFocusChange(view, z);
        }
        MMPhoneNumberEditText.c(this.qFR);
    }
}
