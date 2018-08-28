package com.tencent.mm.modelstat;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.protocal.c.adl;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.x;

class c$4 implements e {
    final /* synthetic */ c eiu;
    final /* synthetic */ a eiw;
    final /* synthetic */ String eix;

    c$4(c cVar, a aVar, String str) {
        this.eiu = cVar;
        this.eiw = aVar;
        this.eix = str;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 1126 && i == 0 && i2 == 0) {
            adl adl = (adl) ((j) lVar).ejL.dIE.dIL;
            if (adl == null) {
                x.e("MicroMsg.ClickFlowStatReceiver", "NetSceneUpdateEventConfig onSceneEnd resp is null");
            } else {
                c.b(this.eiu).post(new 1(this, adl));
            }
        }
    }
}
