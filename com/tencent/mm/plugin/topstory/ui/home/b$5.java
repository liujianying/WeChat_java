package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.mm.g.a.rq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$5 extends c<rq> {
    final /* synthetic */ b ozD;

    b$5(b bVar) {
        this.ozD = bVar;
        this.sFo = rq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rq rqVar = (rq) bVar;
        switch (rqVar.ccx.actionType) {
            case 1:
                rqVar.ccy.ccz = true;
                break;
            case 2:
                this.ozD.ozw.finish();
                break;
            case 3:
                rqVar.ccy.ccA = this.ozD.ccA;
                break;
        }
        return true;
    }
}
