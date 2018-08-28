package com.tencent.mm.az;

import com.tencent.mm.g.a.it;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd.d;

class e$1 implements a {
    final /* synthetic */ d elq;
    final /* synthetic */ e elr;

    e$1(e eVar, d dVar) {
        this.elr = eVar;
        this.elq = dVar;
    }

    public final void x(String str, boolean z) {
        au.HU();
        x.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.FR().Yg(this.elq.tbT)));
        it itVar = new it();
        itVar.bSl.bSm = this.elq.tbT;
        itVar.bSl.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(itVar);
    }
}
