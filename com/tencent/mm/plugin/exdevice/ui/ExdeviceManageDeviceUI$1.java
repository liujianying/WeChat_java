package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceManageDeviceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceManageDeviceUI iDl;

    ExdeviceManageDeviceUI$1(ExdeviceManageDeviceUI exdeviceManageDeviceUI) {
        this.iDl = exdeviceManageDeviceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iDl.finish();
        return true;
    }
}
