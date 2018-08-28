package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.text.Editable;
import android.text.TextWatcher;

class ContactSearchUI$1 implements TextWatcher {
    final /* synthetic */ ContactSearchUI oty;

    ContactSearchUI$1(ContactSearchUI contactSearchUI) {
        this.oty = contactSearchUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        this.oty.enableOptionMenu(editable.length() > 0);
    }
}
