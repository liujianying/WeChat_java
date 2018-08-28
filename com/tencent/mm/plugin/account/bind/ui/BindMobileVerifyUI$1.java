package com.tencent.mm.plugin.account.bind.ui;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bi;

class BindMobileVerifyUI$1 implements InputFilter {
    final /* synthetic */ BindMobileVerifyUI eHl;

    BindMobileVerifyUI$1(BindMobileVerifyUI bindMobileVerifyUI) {
        this.eHl = bindMobileVerifyUI;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return bi.L(charSequence);
    }
}
