package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class LoginUI$24 implements c {
    final /* synthetic */ LoginUI eSk;

    LoginUI$24(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final void a(l lVar) {
        if (lVar.crF()) {
            lVar.eR(5001, j.wechat_safe_center);
            lVar.eR(5002, j.wechat_help_center);
        }
    }
}
