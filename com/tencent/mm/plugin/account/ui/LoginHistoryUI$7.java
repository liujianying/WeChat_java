package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.a$a;

class LoginHistoryUI$7 implements OnClickListener {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$7(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final void onClick(View view) {
        d.A(this.eRA, "login_exdevice", ".ui.LoginAsExDeviceUI");
        this.eRA.overridePendingTransition(a$a.push_down_in, a$a.anim_not_change);
    }
}
