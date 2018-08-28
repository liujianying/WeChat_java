package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.ui.EmailVerifyUI.3;
import com.tencent.mm.ui.base.h;

class EmailVerifyUI$3$1 implements OnClickListener {
    final /* synthetic */ 3 ePY;

    EmailVerifyUI$3$1(3 3) {
        this.ePY = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        z zVar = new z(EmailVerifyUI.a(this.ePY.ePX), EmailVerifyUI.b(this.ePY.ePX));
        g.DF().a(zVar, 0);
        EmailVerifyUI emailVerifyUI = this.ePY.ePX;
        EmailVerifyUI emailVerifyUI2 = this.ePY.ePX;
        this.ePY.ePX.getString(j.app_tip);
        EmailVerifyUI.a(emailVerifyUI, h.a(emailVerifyUI2, this.ePY.ePX.getString(j.regby_email_verify_code_sending), true, new 1(this, zVar)));
    }
}
