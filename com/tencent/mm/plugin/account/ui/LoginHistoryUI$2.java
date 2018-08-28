package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.n.d;

class LoginHistoryUI$2 implements d {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$2(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 7002:
                LoginHistoryUI.d(this.eRA);
                return;
            case 7003:
                LoginHistoryUI.e(this.eRA);
                return;
            case 7004:
                LoginHistoryUI.f(this.eRA);
                return;
            case 7009:
                LoginHistoryUI.P(this.eRA, this.eRA.getString(j.wechat_help_center_url) + w.chP());
                return;
            default:
                return;
        }
    }
}
