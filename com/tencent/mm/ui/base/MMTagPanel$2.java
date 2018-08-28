package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;

class MMTagPanel$2 implements TextWatcher {
    final /* synthetic */ MMTagPanel txS;

    MMTagPanel$2(MMTagPanel mMTagPanel) {
        this.txS = mMTagPanel;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        if (MMTagPanel.e(this.txS) != null) {
            MMTagPanel.e(this.txS).zR(obj);
        }
        if (obj.length() > 0) {
            this.txS.crR();
        }
    }
}
