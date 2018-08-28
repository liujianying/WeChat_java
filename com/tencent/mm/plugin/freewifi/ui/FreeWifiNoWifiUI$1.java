package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiNoWifiUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiNoWifiUI jnO;

    FreeWifiNoWifiUI$1(FreeWifiNoWifiUI freeWifiNoWifiUI) {
        this.jnO = freeWifiNoWifiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jnO.finish();
        return true;
    }
}
