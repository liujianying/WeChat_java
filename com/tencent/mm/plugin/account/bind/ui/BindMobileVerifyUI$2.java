package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

class BindMobileVerifyUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BindMobileVerifyUI eHl;

    BindMobileVerifyUI$2(BindMobileVerifyUI bindMobileVerifyUI) {
        this.eHl = bindMobileVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = BindMobileVerifyUI.a(this.eHl).getText().toString().trim();
        if (trim.equals("")) {
            h.i(this.eHl, j.bind_mcontact_verifynull, j.app_tip);
        } else {
            this.eHl.YC();
            hp hpVar = new hp();
            hpVar.bQV.context = this.eHl;
            a.sFg.m(hpVar);
            String str = hpVar.bQW.bQX;
            hq hqVar = new hq();
            a.sFg.m(hqVar);
            final x xVar = new x(BindMobileVerifyUI.b(this.eHl), 2, trim, "", str, hqVar.bQY.bQZ);
            g.DF().a(xVar, 0);
            BindMobileVerifyUI bindMobileVerifyUI = this.eHl;
            BindMobileVerifyUI bindMobileVerifyUI2 = this.eHl;
            this.eHl.getString(j.app_tip);
            BindMobileVerifyUI.a(bindMobileVerifyUI, h.a(bindMobileVerifyUI2, this.eHl.getString(j.bind_mcontact_verifing), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    g.DF().c(xVar);
                }
            }));
        }
        return true;
    }
}
