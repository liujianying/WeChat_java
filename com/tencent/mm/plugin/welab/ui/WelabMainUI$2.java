package com.tencent.mm.plugin.welab.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WelabMainUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WelabMainUI qnr;

    WelabMainUI$2(WelabMainUI welabMainUI) {
        this.qnr = welabMainUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qnr.YC();
        this.qnr.finish();
        return true;
    }
}
