package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;

class ContactLabelEditUI$11 implements a {
    final /* synthetic */ ContactLabelEditUI kAZ;

    ContactLabelEditUI$11(ContactLabelEditUI contactLabelEditUI) {
        this.kAZ = contactLabelEditUI;
    }

    public final void FH(String str) {
        ContactLabelEditUI.b(this.kAZ, str);
        ContactLabelEditUI.c(this.kAZ, str);
        ContactLabelEditUI.e(this.kAZ).gf(false);
    }

    public final void gd(boolean z) {
        if (ContactLabelEditUI.f(this.kAZ) || !ContactLabelEditUI.g(this.kAZ)) {
            this.kAZ.enableOptionMenu(z);
            return;
        }
        this.kAZ.enableOptionMenu(false);
        ContactLabelEditUI.h(this.kAZ);
    }
}
