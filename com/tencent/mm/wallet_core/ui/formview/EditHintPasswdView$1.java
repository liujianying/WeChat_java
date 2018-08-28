package com.tencent.mm.wallet_core.ui.formview;

import android.text.Editable;
import android.text.TextWatcher;

class EditHintPasswdView$1 implements TextWatcher {
    final /* synthetic */ EditHintPasswdView uZu;

    EditHintPasswdView$1(EditHintPasswdView editHintPasswdView) {
        this.uZu = editHintPasswdView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (EditHintPasswdView.b(this.uZu) != null) {
            EditHintPasswdView.b(this.uZu).fE(EditHintPasswdView.c(this.uZu));
        }
    }
}
