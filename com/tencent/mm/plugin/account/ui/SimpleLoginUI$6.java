package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SimpleLoginUI$6 implements OnClickListener {
    final /* synthetic */ SimpleLoginUI eXn;

    SimpleLoginUI$6(SimpleLoginUI simpleLoginUI) {
        this.eXn = simpleLoginUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(this.eXn).eJa + " img len" + SimpleLoginUI.g(this.eXn).eIZ.length + " " + g.Ac());
        final q qVar = new q(SimpleLoginUI.g(this.eXn).account, SimpleLoginUI.g(this.eXn).eIY, SimpleLoginUI.g(this.eXn).eRQ, SimpleLoginUI.h(this.eXn).getSecImgCode(), SimpleLoginUI.h(this.eXn).getSecImgSid(), SimpleLoginUI.h(this.eXn).getSecImgEncryptKey(), 0, "", false, false);
        com.tencent.mm.kernel.g.DF().a(qVar, 0);
        SimpleLoginUI simpleLoginUI = this.eXn;
        SimpleLoginUI simpleLoginUI2 = this.eXn;
        this.eXn.getString(j.app_tip);
        SimpleLoginUI.a(simpleLoginUI, h.a(simpleLoginUI2, this.eXn.getString(j.login_logining), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                com.tencent.mm.kernel.g.DF().c(qVar);
            }
        }));
    }
}
