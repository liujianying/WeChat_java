package com.tencent.mm.plugin.setting.ui.setting;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.ui.tools.g;

class EditSignatureUI$a implements TextWatcher {
    final /* synthetic */ EditSignatureUI mPP;
    private int mPQ;

    private EditSignatureUI$a(EditSignatureUI editSignatureUI) {
        this.mPP = editSignatureUI;
        this.mPQ = 60;
    }

    /* synthetic */ EditSignatureUI$a(EditSignatureUI editSignatureUI, byte b) {
        this(editSignatureUI);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mPP.enableOptionMenu(true);
    }

    public final void afterTextChanged(Editable editable) {
        this.mPQ = g.be(60, editable.toString());
        if (this.mPQ < 0) {
            this.mPQ = 0;
        }
        if (EditSignatureUI.e(this.mPP) != null) {
            EditSignatureUI.e(this.mPP).setText(this.mPQ);
        }
    }
}
