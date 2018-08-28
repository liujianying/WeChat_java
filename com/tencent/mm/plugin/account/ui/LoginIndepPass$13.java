package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.ui.base.h;

class LoginIndepPass$13 implements OnClickListener {
    final /* synthetic */ LoginIndepPass eRJ;

    LoginIndepPass$13(LoginIndepPass loginIndepPass) {
        this.eRJ = loginIndepPass;
    }

    public final void onClick(View view) {
        h.a(this.eRJ, this.eRJ.getString(a$j.regbymobile_reg_verify_mobile_msg) + LoginIndepPass.c(this.eRJ), this.eRJ.getString(a$j.regbymobile_reg_verify_mobile_title), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.DF().a(145, LoginIndepPass$13.this.eRJ);
                a aVar = new a(LoginIndepPass.d(LoginIndepPass$13.this.eRJ), 16, "", 0, "");
                g.DF().a(aVar, 0);
                LoginIndepPass loginIndepPass = LoginIndepPass$13.this.eRJ;
                Context context = LoginIndepPass$13.this.eRJ;
                LoginIndepPass$13.this.eRJ.getString(a$j.app_tip);
                LoginIndepPass.a(loginIndepPass, h.a(context, LoginIndepPass$13.this.eRJ.getString(a$j.app_loading), true, new 1(this, aVar)));
            }
        }, new 2(this));
    }
}
