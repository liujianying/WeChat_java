package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.ui.base.h;

class MobileLoginOrForceReg$2 implements OnClickListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ Boolean eTA;
    final /* synthetic */ MobileLoginOrForceReg eTx;
    final /* synthetic */ String eTy;
    final /* synthetic */ String eTz;

    MobileLoginOrForceReg$2(MobileLoginOrForceReg mobileLoginOrForceReg, String str, String str2, l lVar, Boolean bool) {
        this.eTx = mobileLoginOrForceReg;
        this.eTy = str;
        this.eTz = str2;
        this.bFp = lVar;
        this.eTA = bool;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        s sVar = new s("", this.eTy, this.eTz, 0, "", MobileLoginOrForceReg.e(this.eTx), "", "", MobileLoginOrForceReg.h(this.eTx), MobileLoginOrForceReg.r(this.eTx), "", ((s) this.bFp).Re(), MobileLoginOrForceReg.p(this.eTx).getSecImgCode(), true, this.eTA.booleanValue());
        sVar.mX(MobileLoginOrForceReg.i(this.eTx));
        sVar.im(MobileLoginOrForceReg.k(this.eTx));
        g.DF().a(sVar, 0);
        MobileLoginOrForceReg mobileLoginOrForceReg = this.eTx;
        Context context = this.eTx.mController.tml;
        this.eTx.getString(a$j.app_tip);
        mobileLoginOrForceReg.eHw = h.a(context, this.eTx.getString(a$j.regbyqq_reg_waiting), true, new 1(this, sVar));
    }
}
