package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LoginHistoryUI$25 implements OnMenuItemClickListener {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$25(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LoginHistoryUI.b(this.eRA);
        return true;
    }
}
