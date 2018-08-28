package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;

class ContactLabelEditUI$12 implements Runnable {
    final /* synthetic */ ContactLabelEditUI kAZ;

    ContactLabelEditUI$12(ContactLabelEditUI contactLabelEditUI) {
        this.kAZ = contactLabelEditUI;
    }

    public final void run() {
        Collection XW = e.aYJ().XW(ContactLabelEditUI.i(this.kAZ));
        if (XW == null) {
            x.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
            return;
        }
        if (XW != null) {
            ContactLabelEditUI.a(this.kAZ, XW);
            if (ContactLabelEditUI.j(this.kAZ) == null) {
                ContactLabelEditUI.b(this.kAZ, new ArrayList());
            } else {
                ContactLabelEditUI.j(this.kAZ).clear();
            }
            ContactLabelEditUI.j(this.kAZ).addAll(XW);
        }
        if (ContactLabelEditUI.k(this.kAZ) != null) {
            ContactLabelEditUI.k(this.kAZ).sendEmptyMessage(6001);
        }
    }

    public final String toString() {
        return super.toString() + "|initView";
    }
}
