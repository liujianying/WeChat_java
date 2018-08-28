package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindMobileStatusUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BindMobileStatusUI eGW;

    BindMobileStatusUI$1(BindMobileStatusUI bindMobileStatusUI) {
        this.eGW = bindMobileStatusUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        BindMobileStatusUI.a(this.eGW);
        return false;
    }
}
