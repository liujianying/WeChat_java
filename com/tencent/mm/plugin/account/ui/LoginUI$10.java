package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.a.a;

class LoginUI$10 implements OnClickListener {
    final /* synthetic */ LoginUI eSk;

    LoginUI$10(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final void onClick(View view) {
        d.A(this.eSk, "login_exdevice", ".ui.LoginAsExDeviceUI");
        this.eSk.overridePendingTransition(a.push_down_in, a.anim_not_change);
    }
}
