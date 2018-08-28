package com.tencent.mm.plugin.remittance.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.map.lib.util.SystemUtil;

class RemittanceBusiUI$21 implements TextWatcher {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$21(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
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
        if (indexOf >= 0 && length - indexOf > 2) {
            editable.delete(indexOf + 3, length);
        }
        if (RemittanceBusiUI.g(this.mBt) == 32) {
            RemittanceBusiUI.a(this.mBt, null, RemittanceBusiUI.h(this.mBt) == null ? SystemUtil.SMALL_SCREEN_THRESHOLD : RemittanceBusiUI.h(this.mBt).mwX);
        }
    }
}
