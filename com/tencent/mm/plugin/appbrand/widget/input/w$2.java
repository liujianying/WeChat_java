package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.TextUtils;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

class w$2 extends InputConnectionWrapper {
    final /* synthetic */ w gIK;

    w$2(w wVar, InputConnection inputConnection) {
        this.gIK = wVar;
        super(inputConnection, false);
    }

    public final boolean setComposingText(CharSequence charSequence, int i) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.gIK.gIJ = charSequence.charAt(charSequence.length() - 1);
        }
        return super.setComposingText(charSequence, i);
    }

    public final boolean commitText(CharSequence charSequence, int i) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.gIK.gIJ = charSequence.charAt(charSequence.length() - 1);
        }
        return super.commitText(charSequence, i);
    }

    public final boolean deleteSurroundingText(int i, int i2) {
        this.gIK.gIJ = 8;
        return super.deleteSurroundingText(i, i2);
    }
}
