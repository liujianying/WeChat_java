package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LoginUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ LoginUI eSk;

    LoginUI$4(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LoginUI.e(this.eSk);
        return true;
    }
}
