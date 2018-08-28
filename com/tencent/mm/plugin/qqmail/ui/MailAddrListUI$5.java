package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MailAddrListUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ MailAddrListUI mgK;

    MailAddrListUI$5(MailAddrListUI mailAddrListUI) {
        this.mgK = mailAddrListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mgK.setResult(0);
        this.mgK.finish();
        return true;
    }
}
