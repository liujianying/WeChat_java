package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;

class SnsCommentFooter$1 implements TextWatcher {
    final /* synthetic */ SnsCommentFooter nVN;

    SnsCommentFooter$1(SnsCommentFooter snsCommentFooter) {
        this.nVN = snsCommentFooter;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (SnsCommentFooter.a(this.nVN).getText() != null) {
            SnsCommentFooter.a(this.nVN).requestFocus();
            boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && this.nVN.kXL) {
                SnsCommentFooter.a(this.nVN, true);
                this.nVN.kXL = false;
            }
            if (!z) {
                SnsCommentFooter.a(this.nVN, false);
                this.nVN.kXL = true;
            }
        }
    }
}
