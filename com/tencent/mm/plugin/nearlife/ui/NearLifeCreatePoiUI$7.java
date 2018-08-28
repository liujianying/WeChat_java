package com.tencent.mm.plugin.nearlife.ui;

import android.text.Editable;
import android.text.TextWatcher;

class NearLifeCreatePoiUI$7 implements TextWatcher {
    final /* synthetic */ NearLifeCreatePoiUI lEr;

    NearLifeCreatePoiUI$7(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.lEr = nearLifeCreatePoiUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (NearLifeCreatePoiUI.d(this.lEr).getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.f(this.lEr).getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.e(this.lEr).getText().toString().trim().length() == 0) {
            this.lEr.enableOptionMenu(0, false);
        } else {
            this.lEr.enableOptionMenu(0, true);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
