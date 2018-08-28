package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindSafeDeviceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BindSafeDeviceUI eOw;

    BindSafeDeviceUI$1(BindSafeDeviceUI bindSafeDeviceUI) {
        this.eOw = bindSafeDeviceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eOw.finish();
        return true;
    }
}
