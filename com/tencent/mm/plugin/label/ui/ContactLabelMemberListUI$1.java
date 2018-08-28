package com.tencent.mm.plugin.label.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelMemberListUI$1 extends ag {
    final /* synthetic */ ContactLabelMemberListUI kBC;

    ContactLabelMemberListUI$1(ContactLabelMemberListUI contactLabelMemberListUI) {
        this.kBC = contactLabelMemberListUI;
    }

    public final void handleMessage(Message message) {
        x.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[]{Integer.valueOf(message.what)});
        switch (message.what) {
            case 5001:
                ContactLabelMemberListUI.a(this.kBC);
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
                return;
        }
    }
}
