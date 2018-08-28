package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements b<c> {
    final /* synthetic */ g onB;

    g$1(g gVar) {
        this.onB = gVar;
    }

    public final /* synthetic */ void a(e eVar) {
        c cVar = (c) eVar;
        x.i("MicroMsg.SoterNetDelegateUtil", "generate and upload ask onResult errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.Yy);
        if (!cVar.isSuccess()) {
            a.dL(1, cVar.errCode);
            if (this.onB.onz != null) {
                this.onB.onz.xN(cVar.errCode);
            }
        } else if (this.onB.onz != null) {
            this.onB.onz.bFc();
        }
    }
}
