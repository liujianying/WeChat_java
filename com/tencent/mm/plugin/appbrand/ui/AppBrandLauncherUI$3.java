package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandLauncherUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandLauncherUI guG;

    AppBrandLauncherUI$3(AppBrandLauncherUI appBrandLauncherUI) {
        this.guG = appBrandLauncherUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.guG.onBackPressed();
        return true;
    }
}
