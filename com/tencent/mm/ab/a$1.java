package com.tencent.mm.ab;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.c.a;
import com.tencent.mm.vending.g.g;

class a$1 implements a<a$a<_Resp>> {
    final /* synthetic */ a dIu;

    a$1(a aVar) {
        this.dIu = aVar;
    }

    public final /* synthetic */ Object call() {
        b cBL = g.cBL();
        this.dIu.dIs.dIz = cBL;
        this.dIu.dIs.dIy = this.dIu.diG;
        if (!v.dKi.DG().a(this.dIu.dIs, 0)) {
            x.e("MicroMsg.Cgi", "RunCgi doScene failed!");
            g.a(cBL);
        }
        return null;
    }
}
