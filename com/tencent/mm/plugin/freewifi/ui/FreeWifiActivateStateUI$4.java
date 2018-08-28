package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiActivateStateUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiActivateStateUI jmf;

    FreeWifiActivateStateUI$4(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.jmf = freeWifiActivateStateUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        FreeWifiActivateStateUI.c(this.jmf);
        return true;
    }
}
