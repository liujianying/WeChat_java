package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.au;

class MailImageDownloadUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MailImageDownloadUI mhA;

    MailImageDownloadUI$1(MailImageDownloadUI mailImageDownloadUI) {
        this.mhA = mailImageDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        au.DF().c(MailImageDownloadUI.a(this.mhA));
        this.mhA.finish();
        return true;
    }
}
