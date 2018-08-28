package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMRadioImageButton.a;

class MMRadioGroupView$a implements a {
    final /* synthetic */ MMRadioGroupView txc;

    MMRadioGroupView$a(MMRadioGroupView mMRadioGroupView) {
        this.txc = mMRadioGroupView;
    }

    public final void a(MMRadioImageButton mMRadioImageButton) {
        if (MMRadioGroupView.a(this.txc) != -1) {
            MMRadioGroupView.a(this.txc, MMRadioGroupView.a(this.txc));
        }
        int id = mMRadioImageButton.getId();
        MMRadioGroupView.a(this.txc, mMRadioImageButton);
        MMRadioGroupView.b(this.txc, id);
    }

    public final void b(MMRadioImageButton mMRadioImageButton) {
        MMRadioGroupView.c(this.txc, mMRadioImageButton.getId());
    }
}
