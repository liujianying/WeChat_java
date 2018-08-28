package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.w;

class LoginUI$22 implements OnClickListener {
    final /* synthetic */ LoginUI eSk;

    LoginUI$22(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final void onClick(View view) {
        LoginUI.Q(this.eSk, this.eSk.getString(j.login_forget_password_help) + w.chP());
    }
}
