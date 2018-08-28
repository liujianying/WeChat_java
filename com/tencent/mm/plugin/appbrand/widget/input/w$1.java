package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import android.text.Editable.Factory;

class w$1 extends Factory {
    final /* synthetic */ w gIK;

    w$1(w wVar) {
        this.gIK = wVar;
    }

    public final Editable newEditable(CharSequence charSequence) {
        return this.gIK.c(super.newEditable(charSequence));
    }
}
