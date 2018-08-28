package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.text.Editable;
import android.text.TextWatcher;

class WxaLuckyMoneyPrepareUI$17 implements TextWatcher {
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;

    WxaLuckyMoneyPrepareUI$17(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI) {
        this.kMq = wxaLuckyMoneyPrepareUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.toString().startsWith(".")) {
            editable.insert(0, "0");
        }
        String obj = editable.toString();
        int indexOf = obj.indexOf(".");
        int length = obj.length();
        if (indexOf >= 0 && length - indexOf > 3) {
            editable.delete(indexOf + 3, length);
        } else if (indexOf > 6) {
            editable.delete(6, indexOf);
        } else if (indexOf == -1 && length > 6) {
            editable.delete(6, length);
        }
    }
}
