package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceBindDeviceGuideUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceBindDeviceGuideUI iAN;

    ExdeviceBindDeviceGuideUI$1(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI) {
        this.iAN = exdeviceBindDeviceGuideUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iAN.finish();
        return true;
    }
}
