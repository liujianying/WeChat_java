package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import android.text.TextWatcher;

class x$3 implements TextWatcher {
    final /* synthetic */ x gIT;

    x$3(x xVar) {
        this.gIT = xVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.gIT.guJ.removeCallbacks(this.gIT.gIS);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
