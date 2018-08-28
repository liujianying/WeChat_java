package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.security.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class SecurityAccountVerifyUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ SecurityAccountVerifyUI ePi;

    SecurityAccountVerifyUI$6(SecurityAccountVerifyUI securityAccountVerifyUI) {
        this.ePi = securityAccountVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = SecurityAccountVerifyUI.g(this.ePi).getText().toString().trim();
        if (bi.oW(trim)) {
            h.i(this.ePi, j.bind_mcontact_verifynull, j.app_tip);
        } else {
            l xVar;
            this.ePi.YC();
            SecurityAccountVerifyUI.a(this.ePi, f.cn(this.ePi));
            SecurityAccountVerifyUI.b(this.ePi, f.Yo());
            if (SecurityAccountVerifyUI.h(this.ePi)) {
                xVar = new x(SecurityAccountVerifyUI.d(this.ePi), 11, trim, "", SecurityAccountVerifyUI.i(this.ePi), SecurityAccountVerifyUI.j(this.ePi));
            } else {
                xVar = new a(SecurityAccountVerifyUI.d(this.ePi), trim, "", SecurityAccountVerifyUI.e(this.ePi), SecurityAccountVerifyUI.i(this.ePi), SecurityAccountVerifyUI.j(this.ePi));
            }
            g.DF().a(xVar, 0);
            SecurityAccountVerifyUI securityAccountVerifyUI = this.ePi;
            SecurityAccountVerifyUI securityAccountVerifyUI2 = this.ePi;
            this.ePi.getString(j.app_tip);
            SecurityAccountVerifyUI.a(securityAccountVerifyUI, h.a(securityAccountVerifyUI2, this.ePi.getString(j.bind_mcontact_verifing), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    g.DF().c(xVar);
                }
            }));
        }
        return true;
    }
}
