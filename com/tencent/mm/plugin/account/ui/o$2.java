package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.ui.base.h;

class o$2 implements OnClickListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ Boolean eTA;
    final /* synthetic */ o eTO;
    final /* synthetic */ String eTy;
    final /* synthetic */ String eTz;

    o$2(o oVar, String str, String str2, l lVar, Boolean bool) {
        this.eTO = oVar;
        this.eTy = str;
        this.eTz = str2;
        this.bFp = lVar;
        this.eTA = bool;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.DF().a(126, this.eTO);
        s sVar = new s("", this.eTy, this.eTz, 0, "", this.eTO.eTG.bTi, "", "", this.eTO.eTM, this.eTO.eTG.egg, "", ((s) this.bFp).Re(), this.eTO.eTG.eIX.getSecImgCode(), true, this.eTA.booleanValue());
        sVar.mX(this.eTO.eTG.eSE);
        g.DF().a(sVar, 0);
        MobileVerifyUI mobileVerifyUI = this.eTO.eTG;
        Context context = this.eTO.eTG;
        this.eTO.eTG.getString(a$j.app_tip);
        mobileVerifyUI.eHw = h.a(context, this.eTO.eTG.getString(a$j.regbyqq_reg_waiting), true, new 1(this, sVar));
    }
}
