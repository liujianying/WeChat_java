package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;

class SnsCommentUI$4 implements TextWatcher {
    final /* synthetic */ SnsCommentUI nVX;

    SnsCommentUI$4(SnsCommentUI snsCommentUI) {
        this.nVX = snsCommentUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (SnsCommentUI.b(this.nVX).getText().toString().trim().length() > 0) {
            this.nVX.enableOptionMenu(true);
        } else {
            this.nVX.enableOptionMenu(false);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
