package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.ui.base.h;

class LoginSmsUI$1 implements OnClickListener {
    final /* synthetic */ LoginSmsUI eRV;

    LoginSmsUI$1(LoginSmsUI loginSmsUI) {
        this.eRV = loginSmsUI;
    }

    public final void onClick(View view) {
        h.a(this.eRV, this.eRV.getString(a$j.regbymobile_reg_verify_mobile_msg) + this.eRV.eRa, this.eRV.getString(a$j.regbymobile_reg_verify_mobile_title), this.eRV.getString(a$j.app_ok), this.eRV.getString(a$j.app_cancel), false, new 1(this), new 2(this));
    }
}
