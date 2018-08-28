package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceExpireUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceExpireUI iCU;

    ExdeviceExpireUI$1(ExdeviceExpireUI exdeviceExpireUI) {
        this.iCU = exdeviceExpireUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iCU.finish();
        return false;
    }
}
