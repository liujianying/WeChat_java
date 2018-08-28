package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ReadMailUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ ReadMailUI miD;

    ReadMailUI$9(ReadMailUI readMailUI) {
        this.miD = readMailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.miD.finish();
        return true;
    }
}
