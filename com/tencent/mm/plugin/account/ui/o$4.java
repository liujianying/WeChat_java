package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.applet.SecurityImage.b;

class o$4 extends b {
    final /* synthetic */ l bFp;
    final /* synthetic */ Boolean eTA;
    final /* synthetic */ o eTO;
    final /* synthetic */ String eTy;
    final /* synthetic */ String eTz;

    o$4(o oVar, String str, String str2, l lVar, Boolean bool) {
        this.eTO = oVar;
        this.eTy = str;
        this.eTz = str2;
        this.bFp = lVar;
        this.eTA = bool;
    }

    public final void Xe() {
        this.eTO.eTG.YC();
        g.DF().a(126, this.eTO);
        s sVar = new s("", this.eTy, this.eTz, 0, "", this.eTO.eTG.bTi, "", "", this.eTO.eTM, this.eTO.eTG.egg, "", ((s) this.bFp).Re(), "", true, this.eTA.booleanValue());
        sVar.mX(this.eTO.eTG.eSE);
        g.DF().a(sVar, 0);
    }
}
