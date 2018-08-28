package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandProfileUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandProfileUI gvm;

    AppBrandProfileUI$1(AppBrandProfileUI appBrandProfileUI) {
        this.gvm = appBrandProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.gvm.onBackPressed();
        return true;
    }
}
