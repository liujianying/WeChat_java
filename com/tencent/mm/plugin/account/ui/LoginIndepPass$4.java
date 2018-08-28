package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LoginIndepPass$4 implements OnClickListener {
    final /* synthetic */ LoginIndepPass eRJ;

    LoginIndepPass$4(LoginIndepPass loginIndepPass) {
        this.eRJ = loginIndepPass;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(this.eRJ).eJa + " img len" + LoginIndepPass.e(this.eRJ).eIZ.length + " " + g.Ac());
        q qVar = new q(LoginIndepPass.e(this.eRJ).account, LoginIndepPass.e(this.eRJ).eIY, LoginIndepPass.e(this.eRJ).eRQ, LoginIndepPass.f(this.eRJ).getSecImgCode(), LoginIndepPass.f(this.eRJ).getSecImgSid(), LoginIndepPass.f(this.eRJ).getSecImgEncryptKey(), 1, "", false, false);
        com.tencent.mm.kernel.g.DF().a(qVar, 0);
        LoginIndepPass loginIndepPass = this.eRJ;
        LoginIndepPass loginIndepPass2 = this.eRJ;
        this.eRJ.getString(j.app_tip);
        LoginIndepPass.a(loginIndepPass, h.a(loginIndepPass2, this.eRJ.getString(j.login_logining), true, new 1(this, qVar)));
    }
}
