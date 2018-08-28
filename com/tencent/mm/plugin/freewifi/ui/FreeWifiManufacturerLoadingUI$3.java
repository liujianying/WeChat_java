package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiManufacturerLoadingUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiManufacturerLoadingUI jnE;

    FreeWifiManufacturerLoadingUI$3(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        this.jnE = freeWifiManufacturerLoadingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jnE.finish();
        return true;
    }
}
