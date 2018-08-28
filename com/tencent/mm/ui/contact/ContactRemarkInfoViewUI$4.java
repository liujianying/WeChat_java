package com.tencent.mm.ui.contact;

import com.tencent.mm.at.c.a;

class ContactRemarkInfoViewUI$4 implements a {
    final /* synthetic */ ContactRemarkInfoViewUI ujm;

    ContactRemarkInfoViewUI$4(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        this.ujm = contactRemarkInfoViewUI;
    }

    public final void bM(boolean z) {
        ContactRemarkInfoViewUI.f(this.ujm).post(new 1(this, z));
    }
}
