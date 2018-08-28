package com.tencent.mm.plugin.bbom;

import com.tencent.mm.g.a.jy;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.storage.u;

class l$1 implements a {
    final /* synthetic */ String dAt;
    final /* synthetic */ u dhg;
    final /* synthetic */ l hew;

    l$1(l lVar, u uVar, String str) {
        this.hew = lVar;
        this.dhg = uVar;
        this.dAt = str;
    }

    public final void x(String str, boolean z) {
        if (this.dhg != null && this.dhg.ckL()) {
            jy jyVar = new jy();
            jyVar.bUc.chatroomName = this.dAt;
            jyVar.bUc.bUd = this.dhg.ckK();
            com.tencent.mm.sdk.b.a.sFg.m(jyVar);
        }
    }
}
