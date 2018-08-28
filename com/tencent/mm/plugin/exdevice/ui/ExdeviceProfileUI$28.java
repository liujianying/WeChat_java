package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceProfileUI$28 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$28(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iEx.finish();
        return false;
    }
}
