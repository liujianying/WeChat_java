package com.tencent.mm.plugin.welab.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WelabAppInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WelabAppInfoUI qng;

    WelabAppInfoUI$1(WelabAppInfoUI welabAppInfoUI) {
        this.qng = welabAppInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qng.YC();
        this.qng.finish();
        return true;
    }
}
