package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class ContactLabelManagerUI$8 implements b {
    final /* synthetic */ ContactLabelManagerUI kBk;

    ContactLabelManagerUI$8(ContactLabelManagerUI contactLabelManagerUI) {
        this.kBk = contactLabelManagerUI;
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", Integer.valueOf(i), obj);
        if (ContactLabelManagerUI.c(this.kBk) != null) {
            ContactLabelManagerUI.c(this.kBk).removeMessages(5001);
            ContactLabelManagerUI.c(this.kBk).sendEmptyMessageDelayed(5001, 400);
        }
    }
}
