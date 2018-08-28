package com.tencent.mm.plugin.account.security.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.ui.base.h;

class SecurityAccountIntroUI$1 implements OnClickListener {
    final /* synthetic */ SecurityAccountIntroUI ePa;

    SecurityAccountIntroUI$1(SecurityAccountIntroUI securityAccountIntroUI) {
        this.ePa = securityAccountIntroUI;
    }

    public final void onClick(View view) {
        l xVar;
        if (SecurityAccountIntroUI.a(this.ePa)) {
            xVar = new x(SecurityAccountIntroUI.b(this.ePa), 10, "", 0, "");
        } else {
            xVar = new a(SecurityAccountIntroUI.b(this.ePa), 10, "", "", SecurityAccountIntroUI.c(this.ePa));
        }
        g.DF().a(xVar, 0);
        SecurityAccountIntroUI securityAccountIntroUI = this.ePa;
        SecurityAccountIntroUI securityAccountIntroUI2 = this.ePa;
        this.ePa.getString(j.app_tip);
        SecurityAccountIntroUI.a(securityAccountIntroUI, h.a(securityAccountIntroUI2, this.ePa.getString(j.safe_device_sending_verify_code), true, new 1(this, xVar)));
    }
}
