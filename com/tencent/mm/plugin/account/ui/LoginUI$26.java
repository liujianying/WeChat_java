package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.n$d;

class LoginUI$26 implements n$d {
    final /* synthetic */ LoginUI eSk;

    LoginUI$26(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 5001:
                LoginUI.d(this.eSk);
                return;
            case 5002:
                LoginUI.Q(this.eSk, this.eSk.getString(j.wechat_help_center_url) + w.chP());
                return;
            default:
                return;
        }
    }
}
