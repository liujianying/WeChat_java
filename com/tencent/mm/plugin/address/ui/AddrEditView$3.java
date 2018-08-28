package com.tencent.mm.plugin.address.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.x;

class AddrEditView$3 implements TextWatcher {
    final /* synthetic */ AddrEditView eYR;

    AddrEditView$3(AddrEditView addrEditView) {
        this.eYR = addrEditView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean ZF = this.eYR.ZF();
        if (!(ZF == AddrEditView.a(this.eYR) || AddrEditView.b(this.eYR) == null)) {
            x.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(this.eYR) + ", editType:" + AddrEditView.d(this.eYR) + " inputValid change to " + ZF);
            AddrEditView.a(this.eYR, ZF);
            AddrEditView.b(this.eYR).ZC();
        }
        AddrEditView.b(this.eYR, AddrEditView.e(this.eYR).isFocused());
    }
}
