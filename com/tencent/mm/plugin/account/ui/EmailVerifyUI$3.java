package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.base.h;

class EmailVerifyUI$3 implements OnClickListener {
    final /* synthetic */ EmailVerifyUI ePX;

    EmailVerifyUI$3(EmailVerifyUI emailVerifyUI) {
        this.ePX = emailVerifyUI;
    }

    public final void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R500_250,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R500_250")).append(",3").toString());
        h.a(this.ePX, j.regby_email_resend_verify_code, j.regby_email_err_tip_title, j.app_ok, j.app_cancel, new 1(this), null);
    }
}
