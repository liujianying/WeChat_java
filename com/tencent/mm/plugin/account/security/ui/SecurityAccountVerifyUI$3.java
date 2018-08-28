package com.tencent.mm.plugin.account.security.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SecurityAccountVerifyUI$3 implements OnClickListener {
    final /* synthetic */ SecurityAccountVerifyUI ePi;

    SecurityAccountVerifyUI$3(SecurityAccountVerifyUI securityAccountVerifyUI) {
        this.ePi = securityAccountVerifyUI;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
        SecurityAccountVerifyUI.b(this.ePi).setVisibility(8);
        SecurityAccountVerifyUI.a(this.ePi).setTag(Integer.valueOf(60));
        SecurityAccountVerifyUI.c(this.ePi).SO();
        SecurityAccountVerifyUI.c(this.ePi).J(1000, 1000);
        a aVar = new a(SecurityAccountVerifyUI.d(this.ePi), 10, "", "", SecurityAccountVerifyUI.e(this.ePi));
        g.DF().a(aVar, 0);
        SecurityAccountVerifyUI securityAccountVerifyUI = this.ePi;
        ActionBarActivity actionBarActivity = this.ePi.mController.tml;
        this.ePi.getString(j.app_tip);
        SecurityAccountVerifyUI.a(securityAccountVerifyUI, h.a(actionBarActivity, this.ePi.getString(j.safe_device_sending_verify_code), true, new 1(this, aVar)));
    }
}
