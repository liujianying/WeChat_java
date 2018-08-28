package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class l$2 implements OnClickListener {
    final /* synthetic */ l eSI;
    final /* synthetic */ f eSJ;

    l$2(l lVar, f fVar) {
        this.eSI = lVar;
        this.eSJ = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.eSJ.eJa + " img len" + this.eSJ.eIZ.length + " " + g.Ac());
        q qVar = new q(this.eSJ.account, this.eSJ.eIY, this.eSJ.eRQ, this.eSI.eIX.getSecImgCode(), this.eSI.eIX.getSecImgSid(), this.eSI.eIX.getSecImgEncryptKey(), 1, "", false, false);
        com.tencent.mm.kernel.g.DF().a(qVar, 0);
        MobileInputUI mobileInputUI = this.eSI.eSu;
        Context context = this.eSI.eSu;
        this.eSI.eSu.getString(a$j.app_tip);
        mobileInputUI.eIV = h.a(context, this.eSI.eSu.getString(a$j.login_logining), true, new 1(this, qVar));
    }
}
