package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class m$2 implements OnClickListener {
    final /* synthetic */ m eTI;

    m$2(m mVar) {
        this.eTI = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.eTI.eQY.eJa + " img len" + this.eTI.eQY.eIZ.length + " " + g.Ac());
        q qVar = new q(this.eTI.eQY.account, this.eTI.eQY.eRP, this.eTI.eQY.eRQ, this.eTI.eIX.getSecImgCode(), this.eTI.eIX.getSecImgSid(), this.eTI.eIX.getSecImgEncryptKey(), 1, "", false, true);
        com.tencent.mm.kernel.g.DF().a(qVar, 0);
        MobileVerifyUI mobileVerifyUI = this.eTI.eTG;
        this.eTI.eTG.getString(j.app_tip);
        h.a(mobileVerifyUI, this.eTI.eTG.getString(j.login_logining), true, new 1(this, qVar));
    }
}
