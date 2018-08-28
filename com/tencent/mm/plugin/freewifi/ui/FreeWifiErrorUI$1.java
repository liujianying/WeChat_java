package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiErrorUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiErrorUI jmO;

    FreeWifiErrorUI$1(FreeWifiErrorUI freeWifiErrorUI) {
        this.jmO = freeWifiErrorUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jmO.finish();
        return true;
    }
}
