package com.tencent.mm.plugin.recharge.ui.form;

import android.telephony.PhoneNumberUtils;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.ui.form.c.a;

class c$1 extends a {
    c$1() {
        super((byte) 0);
    }

    public final boolean a(MallFormView mallFormView) {
        return PhoneNumberUtils.isGlobalPhoneNumber(b.pK(mallFormView.getText().toString()));
    }

    public final boolean bqk() {
        return true;
    }

    public final String Kq(String str) {
        return str == null ? "" : str.replaceAll(" ", "");
    }
}
