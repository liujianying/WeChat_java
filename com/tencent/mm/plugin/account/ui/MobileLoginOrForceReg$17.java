package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class MobileLoginOrForceReg$17 implements OnClickListener {
    final /* synthetic */ MobileLoginOrForceReg eTx;

    MobileLoginOrForceReg$17(MobileLoginOrForceReg mobileLoginOrForceReg) {
        this.eTx = mobileLoginOrForceReg;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.o(this.eTx).eJa + " img len" + MobileLoginOrForceReg.o(this.eTx).eIZ.length + " " + g.Ac());
        q qVar = new q(MobileLoginOrForceReg.o(this.eTx).account, MobileLoginOrForceReg.o(this.eTx).eRP, MobileLoginOrForceReg.o(this.eTx).eRQ, MobileLoginOrForceReg.p(this.eTx).getSecImgCode(), MobileLoginOrForceReg.p(this.eTx).getSecImgSid(), MobileLoginOrForceReg.p(this.eTx).getSecImgEncryptKey(), 1, "", false, true);
        com.tencent.mm.kernel.g.DF().a(qVar, 0);
        Context context = this.eTx;
        this.eTx.getString(a$j.app_tip);
        h.a(context, this.eTx.getString(a$j.login_logining), true, new 1(this, qVar));
    }
}
