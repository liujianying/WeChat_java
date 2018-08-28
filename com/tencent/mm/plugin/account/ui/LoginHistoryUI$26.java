package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.w;

class LoginHistoryUI$26 implements OnClickListener {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$26(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final void onClick(View view) {
        LoginHistoryUI.P(this.eRA, this.eRA.getString(j.login_forget_password_help) + w.chP());
    }
}
