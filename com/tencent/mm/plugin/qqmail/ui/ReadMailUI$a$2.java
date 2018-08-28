package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;

class ReadMailUI$a$2 implements Runnable {
    final /* synthetic */ a miN;

    ReadMailUI$a$2(a aVar) {
        this.miN = aVar;
    }

    public final void run() {
        ReadMailUI.h(this.miN.miD).setEnabled(false);
        ReadMailUI.h(this.miN.miD).setText(R.l.readmail_set_unreaded);
        ReadMailUI.h(this.miN.miD).setTextColor(-7829368);
        ReadMailUI.h(this.miN.miD).setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bp.a.f(this.miN.miD, R.g.set_unread_icon), null, null, null);
    }
}
