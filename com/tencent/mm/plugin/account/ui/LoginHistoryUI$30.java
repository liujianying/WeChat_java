package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class LoginHistoryUI$30 implements c {
    final /* synthetic */ LoginHistoryUI eRA;

    LoginHistoryUI$30(LoginHistoryUI loginHistoryUI) {
        this.eRA = loginHistoryUI;
    }

    public final void a(l lVar) {
        if (lVar.size() == 0) {
            lVar.eR(7002, a$j.login_by_others);
            lVar.eR(7003, a$j.intro_create_account_qq);
            lVar.eR(7004, a$j.wechat_safe_center);
            if (!w.chM()) {
                lVar.eR(7009, a$j.wechat_help_center);
            }
        }
    }
}
