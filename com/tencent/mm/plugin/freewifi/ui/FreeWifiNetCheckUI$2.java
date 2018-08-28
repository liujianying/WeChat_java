package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiNetCheckUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiNetCheckUI jnK;

    FreeWifiNetCheckUI$2(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        this.jnK = freeWifiNetCheckUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jnK.finish();
        return true;
    }
}
