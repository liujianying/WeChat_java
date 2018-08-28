package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LoginIndepPass$9 implements OnMenuItemClickListener {
    final /* synthetic */ LoginIndepPass eRJ;

    LoginIndepPass$9(LoginIndepPass loginIndepPass) {
        this.eRJ = loginIndepPass;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LoginIndepPass.a(this.eRJ);
        return true;
    }
}
