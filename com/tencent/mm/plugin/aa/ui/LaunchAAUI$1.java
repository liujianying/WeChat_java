package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LaunchAAUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ LaunchAAUI eDS;

    LaunchAAUI$1(LaunchAAUI launchAAUI) {
        this.eDS = launchAAUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eDS.finish();
        return false;
    }
}
