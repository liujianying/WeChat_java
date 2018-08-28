package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.4;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.b;

class ContactLabelManagerUI$4$1 implements Runnable {
    final /* synthetic */ 4 kBn;

    ContactLabelManagerUI$4$1(4 4) {
        this.kBn = 4;
    }

    public final void run() {
        ContactLabelManagerUI.a(this.kBn.kBk, b.kBq);
        if (this.kBn.kBm && ContactLabelManagerUI.c(this.kBn.kBk) != null) {
            ContactLabelManagerUI.c(this.kBn.kBk).removeMessages(5002);
            ContactLabelManagerUI.c(this.kBn.kBk).sendEmptyMessageDelayed(5003, 0);
        }
    }
}
