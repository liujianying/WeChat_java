package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelEditUI$10 implements a {
    final /* synthetic */ ContactLabelEditUI kAZ;

    ContactLabelEditUI$10(ContactLabelEditUI contactLabelEditUI) {
        this.kAZ = contactLabelEditUI;
    }

    public final void og(int i) {
        if (ContactLabelEditUI.c(this.kAZ).Cb(i)) {
            String Cc = ContactLabelEditUI.c(this.kAZ).Cc(i);
            String Cd = ContactLabelEditUI.c(this.kAZ).Cd(i);
            if (!bi.oW(Cc)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", Cc);
                intent.putExtra("Contact_RoomNickname", Cd);
                com.tencent.mm.plugin.label.a.ezn.d(intent, this.kAZ);
            }
        }
    }

    public final void aAK() {
        if (ContactLabelEditUI.c(this.kAZ) != null) {
            ContactLabelEditUI.c(this.kAZ).cdV();
        }
    }

    public final void oh(int i) {
        ContactLabelEditUI.d(this.kAZ);
    }

    public final void of(int i) {
        x.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[]{Integer.valueOf(i), ContactLabelEditUI.c(this.kAZ).Cc(i)});
        ContactLabelEditUI.a(this.kAZ, r0);
    }
}
