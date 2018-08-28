package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ModSafeDeviceNameUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ModSafeDeviceNameUI eOB;

    ModSafeDeviceNameUI$1(ModSafeDeviceNameUI modSafeDeviceNameUI) {
        this.eOB = modSafeDeviceNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eOB.finish();
        return true;
    }
}
