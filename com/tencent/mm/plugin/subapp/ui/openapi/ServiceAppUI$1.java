package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ServiceAppUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ServiceAppUI osX;

    ServiceAppUI$1(ServiceAppUI serviceAppUI) {
        this.osX = serviceAppUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.osX.finish();
        return true;
    }
}
