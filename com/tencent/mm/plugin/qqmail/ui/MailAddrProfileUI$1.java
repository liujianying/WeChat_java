package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MailAddrProfileUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MailAddrProfileUI mgS;

    MailAddrProfileUI$1(MailAddrProfileUI mailAddrProfileUI) {
        this.mgS = mailAddrProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mgS.YC();
        this.mgS.finish();
        return true;
    }
}
