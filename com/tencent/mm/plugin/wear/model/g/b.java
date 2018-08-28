package com.tencent.mm.plugin.wear.model.g;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class b implements d {
    public final com.tencent.mm.ab.d.b b(a aVar) {
        by byVar = aVar.dIN;
        au.HU();
        if (!bi.oW((String) c.DT().get(2, ""))) {
            String a = ab.a(byVar.rcj);
            String a2 = ab.a(byVar.rck);
            if (bi.oW(a) || bi.oW(a2)) {
                x.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
            } else {
                String a3 = ab.a(byVar.rcl);
                x.i("MicroMsg.YoExtension", "from  " + a + "content " + a3);
                a aVar2 = com.tencent.mm.plugin.wear.model.a.bSl().pIT;
                synchronized (aVar2.pKi) {
                    ts PR = a.PR(a);
                    if (aVar2.pKi.containsKey(a) || PR.cft.cfu == 1) {
                        x.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[]{a});
                        ts tsVar = new ts();
                        tsVar.cfs.bIH = 2;
                        tsVar.cfs.username = a;
                        com.tencent.mm.sdk.b.a.sFg.m(tsVar);
                    } else {
                        x.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[]{a});
                        aVar2.pKi.put(a, new a.a(aVar2, a, a3));
                    }
                }
                com.tencent.mm.plugin.wear.model.a.bSl().pIT.bSB();
            }
        }
        return null;
    }

    public final void h(bd bdVar) {
    }
}
