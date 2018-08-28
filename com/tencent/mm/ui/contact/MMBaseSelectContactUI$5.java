package com.tencent.mm.ui.contact;

import com.tencent.mm.ui.contact.LabelContainerView.a;

class MMBaseSelectContactUI$5 implements a {
    final /* synthetic */ MMBaseSelectContactUI ukl;

    MMBaseSelectContactUI$5(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.ukl = mMBaseSelectContactUI;
    }

    public final void aGr() {
        if (MMBaseSelectContactUI.d(this.ukl) != null) {
            MMBaseSelectContactUI.d(this.ukl).clearFocus();
        }
        if (MMBaseSelectContactUI.h(this.ukl) != null) {
            MMBaseSelectContactUI.h(this.ukl).clearFocus();
            MMBaseSelectContactUI.h(this.ukl).czQ();
        }
        MMBaseSelectContactUI.i(this.ukl).requestFocus();
        MMBaseSelectContactUI.i(this.ukl).setVisibility(8);
    }

    public final void aGs() {
        this.ukl.YC();
    }
}
