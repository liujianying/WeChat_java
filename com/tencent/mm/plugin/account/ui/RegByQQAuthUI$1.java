package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.base.h;

class RegByQQAuthUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RegByQQAuthUI eWg;

    RegByQQAuthUI$1(RegByQQAuthUI regByQQAuthUI) {
        this.eWg = regByQQAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        RegByQQAuthUI.a(this.eWg, RegByQQAuthUI.a(this.eWg).getText().toString().trim());
        if (RegByQQAuthUI.b(this.eWg).equals("")) {
            h.i(this.eWg, j.verify_account_null_tip, j.app_err_reg_title);
        } else {
            s sVar = new s("", RegByQQAuthUI.c(this.eWg), RegByQQAuthUI.b(this.eWg), RegByQQAuthUI.d(this.eWg), "", "", RegByQQAuthUI.e(this.eWg), 2);
            g.DF().a(sVar, 0);
            RegByQQAuthUI regByQQAuthUI = this.eWg;
            RegByQQAuthUI regByQQAuthUI2 = this.eWg;
            this.eWg.getString(j.app_tip);
            RegByQQAuthUI.a(regByQQAuthUI, h.a(regByQQAuthUI2, this.eWg.getString(j.regbyqq_reg_waiting), true, new 1(this, sVar)));
        }
        return true;
    }
}
