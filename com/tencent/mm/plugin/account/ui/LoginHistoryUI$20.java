package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class LoginHistoryUI$20 implements d {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$20(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        LoginHistoryUI.a(this.eRA, menuItem.getItemId());
    }
}
