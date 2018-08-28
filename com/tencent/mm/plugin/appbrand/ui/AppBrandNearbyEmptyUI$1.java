package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandNearbyEmptyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandNearbyEmptyUI guQ;

    AppBrandNearbyEmptyUI$1(AppBrandNearbyEmptyUI appBrandNearbyEmptyUI) {
        this.guQ = appBrandNearbyEmptyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.guQ.onBackPressed();
        return true;
    }
}
