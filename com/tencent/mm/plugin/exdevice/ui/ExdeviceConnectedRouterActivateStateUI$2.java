package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceConnectedRouterActivateStateUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceConnectedRouterActivateStateUI iCC;

    ExdeviceConnectedRouterActivateStateUI$2(ExdeviceConnectedRouterActivateStateUI exdeviceConnectedRouterActivateStateUI) {
        this.iCC = exdeviceConnectedRouterActivateStateUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ExdeviceConnectedRouterActivateStateUI.a(this.iCC);
        return true;
    }
}
