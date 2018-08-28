package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.normsg.a.b;

class SayHiEditUI$a implements TextWatcher {
    private boolean dsw;

    private SayHiEditUI$a() {
        this.dsw = false;
    }

    /* synthetic */ SayHiEditUI$a(byte b) {
        this();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.dsw) {
            this.dsw = true;
            b.lFJ.S(3, 2, 5);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
