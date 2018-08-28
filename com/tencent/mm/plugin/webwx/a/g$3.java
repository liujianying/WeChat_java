package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.g.a.or;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.c;

class g$3 extends c<or> {
    final /* synthetic */ g qmg;

    g$3(g gVar) {
        this.qmg = gVar;
        this.sFo = or.class.getName().hashCode();
    }

    private boolean a(or orVar) {
        if (orVar != null && (orVar instanceof or)) {
            d dVar = new d(orVar.bZC.bZD);
            au.DF().a(971, new 1(this, dVar, orVar));
            au.DF().a(dVar, 0);
        }
        return false;
    }
}
