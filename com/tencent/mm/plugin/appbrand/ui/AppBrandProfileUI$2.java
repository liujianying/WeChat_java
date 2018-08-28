package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandProfileUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandProfileUI gvm;

    AppBrandProfileUI$2(AppBrandProfileUI appBrandProfileUI) {
        this.gvm = appBrandProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        AppBrandProfileUI.a(this.gvm);
        return true;
    }
}
