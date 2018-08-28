package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.ui.tools.g;

class ModRemarkNameUI$b implements TextWatcher {
    private int mPQ;
    final /* synthetic */ ModRemarkNameUI ukX;

    private ModRemarkNameUI$b(ModRemarkNameUI modRemarkNameUI) {
        this.ukX = modRemarkNameUI;
        this.mPQ = 800;
    }

    /* synthetic */ ModRemarkNameUI$b(ModRemarkNameUI modRemarkNameUI, byte b) {
        this(modRemarkNameUI);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        this.mPQ = g.be(800, editable.toString());
        if (this.mPQ < 0) {
            this.mPQ = 0;
        }
        if (ModRemarkNameUI.i(this.ukX) != null) {
            ModRemarkNameUI.i(this.ukX).setText(this.mPQ);
        }
        ModRemarkNameUI.j(this.ukX);
    }
}
