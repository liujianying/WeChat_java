package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiPcUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiPcUI jnS;

    FreeWifiPcUI$1(FreeWifiPcUI freeWifiPcUI) {
        this.jnS = freeWifiPcUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        FreeWifiPcUI.a(this.jnS);
        return true;
    }
}
