package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ReadMailUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ ReadMailUI miD;

    ReadMailUI$13(ReadMailUI readMailUI) {
        this.miD = readMailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.miD, null, this.miD.getResources().getStringArray(R.c.mail_reply), this.miD.getResources().getString(R.l.readmail_delete), false, new 1(this));
        return false;
    }
}
