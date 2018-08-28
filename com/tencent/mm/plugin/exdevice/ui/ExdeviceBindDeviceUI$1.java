package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceBindDeviceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceBindDeviceUI iBf;

    ExdeviceBindDeviceUI$1(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
        this.iBf = exdeviceBindDeviceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iBf.finish();
        return true;
    }
}
