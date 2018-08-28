package com.tencent.mm.plugin.account.ui;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bi;

class MobileVerifyUI$5 implements InputFilter {
    final /* synthetic */ MobileVerifyUI eUo;

    MobileVerifyUI$5(MobileVerifyUI mobileVerifyUI) {
        this.eUo = mobileVerifyUI;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return bi.L(charSequence);
    }
}
