package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;

class ContactLabelManagerUI$4 implements Runnable {
    final /* synthetic */ ContactLabelManagerUI kBk;
    final /* synthetic */ boolean kBm;

    ContactLabelManagerUI$4(ContactLabelManagerUI contactLabelManagerUI, boolean z) {
        this.kBk = contactLabelManagerUI;
        this.kBm = z;
    }

    public final void run() {
        ContactLabelManagerUI.a(this.kBk, e.aYJ().cle());
        if (ContactLabelManagerUI.g(this.kBk) == null || ContactLabelManagerUI.g(this.kBk).size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
            if (ContactLabelManagerUI.h(this.kBk)) {
                h.mEJ.h(11346, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                ContactLabelManagerUI.i(this.kBk);
            }
            ah.A(new 1(this));
            return;
        }
        x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
        if (ContactLabelManagerUI.h(this.kBk)) {
            h.mEJ.h(11346, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            ContactLabelManagerUI.i(this.kBk);
        }
        if (ContactLabelManagerUI.g(this.kBk) != null && ContactLabelManagerUI.g(this.kBk).size() > 0) {
            int size = ContactLabelManagerUI.g(this.kBk).size();
            e.aYJ().aYE();
            for (int i = 0; i < size; i++) {
                int i2 = ((ad) ContactLabelManagerUI.g(this.kBk).get(i)).field_labelID;
                ArrayList XW = e.aYJ().XW(String.valueOf(i2));
                if (XW == null || XW.size() <= 0) {
                    ContactLabelManagerUI.j(this.kBk).put(Integer.valueOf(i2), Integer.valueOf(0));
                } else {
                    ContactLabelManagerUI.j(this.kBk).put(Integer.valueOf(i2), Integer.valueOf(XW.size()));
                }
            }
        }
        ah.A(new 2(this));
    }

    public final String toString() {
        return super.toString() + "|updateData";
    }
}
