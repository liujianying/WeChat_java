package com.tencent.mm.plugin.game.widget;

import android.text.Editable;
import android.text.TextWatcher;

class a$a implements TextWatcher {
    final /* synthetic */ a kgJ;

    private a$a(a aVar) {
        this.kgJ = aVar;
    }

    /* synthetic */ a$a(a aVar, byte b) {
        this(aVar);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.kgJ.aVD();
    }

    public final void afterTextChanged(Editable editable) {
    }
}
