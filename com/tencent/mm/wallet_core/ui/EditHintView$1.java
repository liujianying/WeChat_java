package com.tencent.mm.wallet_core.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.x;

class EditHintView$1 implements TextWatcher {
    final /* synthetic */ EditHintView uYF;

    EditHintView$1(EditHintView editHintView) {
        this.uYF = editHintView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (EditHintView.a(this.uYF) == 4 && this.uYF.ZF()) {
            EditHintView.b(this.uYF);
            this.uYF.uYu.ClearInput();
        }
    }

    public final void afterTextChanged(Editable editable) {
        boolean ZF = this.uYF.ZF();
        if (!(ZF == EditHintView.c(this.uYF) || EditHintView.d(this.uYF) == null)) {
            x.d("MicroMsg.EditHintView", "View:" + EditHintView.e(this.uYF) + ", editType:" + EditHintView.f(this.uYF) + " inputValid change to " + ZF);
            EditHintView.a(this.uYF, ZF);
        }
        EditHintView.g(this.uYF);
    }
}
