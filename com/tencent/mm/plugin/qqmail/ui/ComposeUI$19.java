package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

class ComposeUI$19 implements a {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$19(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void b(MailAddrsViewControl mailAddrsViewControl) {
        h.a(this.mfs.mController.tml, this.mfs.getString(R.l.plugin_qqmail_mail_addr_format_invalid), "", new 1(this, mailAddrsViewControl), new 2(this, mailAddrsViewControl));
    }

    public final void boN() {
        s.a(this.mfs, this.mfs.getString(R.l.plugin_qqmail_mail_addr_format_invalid), 1500);
    }
}
