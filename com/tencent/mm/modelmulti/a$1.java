package com.tencent.mm.modelmulti;

import com.tencent.mm.g.a.jy;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.storage.u;

class a$1 implements a {
    final /* synthetic */ String dYC;
    final /* synthetic */ a dYD;
    final /* synthetic */ u dhg;

    a$1(a aVar, u uVar, String str) {
        this.dYD = aVar;
        this.dhg = uVar;
        this.dYC = str;
    }

    public final void x(String str, boolean z) {
        if (this.dhg != null && this.dhg.ckL()) {
            jy jyVar = new jy();
            jyVar.bUc.chatroomName = this.dYC;
            jyVar.bUc.bUd = this.dhg.ckK();
            com.tencent.mm.sdk.b.a.sFg.m(jyVar);
        }
    }
}
