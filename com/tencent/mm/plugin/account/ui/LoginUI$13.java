package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LoginUI$13 implements OnClickListener {
    final /* synthetic */ LoginUI eSk;

    LoginUI$13(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (LoginUI.i(this.eSk) == null) {
            x.e("MicroMsg.LoginUI", "secimg is null!");
            return;
        }
        x.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.j(this.eSk).eJa + " img len" + LoginUI.j(this.eSk).eIZ.length + " " + g.Ac());
        q qVar = new q(LoginUI.j(this.eSk).account, LoginUI.j(this.eSk).eIY, LoginUI.j(this.eSk).eRQ, LoginUI.i(this.eSk).getSecImgCode(), LoginUI.i(this.eSk).getSecImgSid(), LoginUI.i(this.eSk).getSecImgEncryptKey(), 2, "", false, false);
        com.tencent.mm.kernel.g.DF().a(qVar, 0);
        LoginUI loginUI = this.eSk;
        LoginUI loginUI2 = this.eSk;
        this.eSk.getString(j.app_tip);
        LoginUI.a(loginUI, h.a(loginUI2, this.eSk.getString(j.login_logining), true, new 1(this, qVar)));
    }
}
