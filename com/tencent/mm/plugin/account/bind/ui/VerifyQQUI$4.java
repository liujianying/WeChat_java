package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.ui.base.h;

class VerifyQQUI$4 implements OnClickListener {
    final /* synthetic */ VerifyQQUI eJq;

    VerifyQQUI$4(VerifyQQUI verifyQQUI) {
        this.eJq = verifyQQUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b bVar = new b(VerifyQQUI.b(this.eJq), VerifyQQUI.c(this.eJq), VerifyQQUI.g(this.eJq).getSecImgSid(), VerifyQQUI.g(this.eJq).getSecImgCode(), VerifyQQUI.g(this.eJq).getSecImgEncryptKey(), VerifyQQUI.d(this.eJq), VerifyQQUI.e(this.eJq), true);
        g.DF().a(bVar, 0);
        VerifyQQUI verifyQQUI = this.eJq;
        ActionBarActivity actionBarActivity = this.eJq.mController.tml;
        this.eJq.getString(j.bind_qq_verify_alert_title);
        VerifyQQUI.a(verifyQQUI, h.a(actionBarActivity, this.eJq.getString(j.bind_qq_verify_alert_binding), true, new 1(this, bVar)));
    }
}
