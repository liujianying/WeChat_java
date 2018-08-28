package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.applet.SecurityImage.b;

class MobileLoginOrForceReg$4 extends b {
    final /* synthetic */ l bFp;
    final /* synthetic */ Boolean eTA;
    final /* synthetic */ MobileLoginOrForceReg eTx;
    final /* synthetic */ String eTy;
    final /* synthetic */ String eTz;

    MobileLoginOrForceReg$4(MobileLoginOrForceReg mobileLoginOrForceReg, String str, String str2, l lVar, Boolean bool) {
        this.eTx = mobileLoginOrForceReg;
        this.eTy = str;
        this.eTz = str2;
        this.bFp = lVar;
        this.eTA = bool;
    }

    public final void Xe() {
        this.eTx.YC();
        s sVar = new s("", this.eTy, this.eTz, 0, "", MobileLoginOrForceReg.e(this.eTx), "", "", MobileLoginOrForceReg.h(this.eTx), MobileLoginOrForceReg.r(this.eTx), "", ((s) this.bFp).Re(), "", true, this.eTA.booleanValue());
        sVar.mX(MobileLoginOrForceReg.i(this.eTx));
        sVar.im(MobileLoginOrForceReg.k(this.eTx));
        g.DF().a(sVar, 0);
    }
}
