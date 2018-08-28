package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandAuthorizeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandAuthorizeUI guf;

    AppBrandAuthorizeUI$1(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        this.guf = appBrandAuthorizeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        AppBrandAuthorizeUI.a(this.guf);
        this.guf.finish();
        return false;
    }
}
