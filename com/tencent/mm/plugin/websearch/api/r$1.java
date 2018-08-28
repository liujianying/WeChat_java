package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.cfl;
import com.tencent.mm.protocal.c.cfm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class r$1 implements e {
    r$1() {
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar instanceof l) {
            g.DF().b(1948, r.bFL());
            tt ttVar = new tt();
            if (i == 0 && i2 == 0) {
                l lVar2 = (l) lVar;
                cfm cfm = lVar2.pLl;
                cfl cfl = lVar2.pLk;
                x.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[]{cfm.rjK});
                if (r.fi(cfl.iwP, cfm.rjK) == r$a.pLI) {
                    ttVar.cfv.result = 0;
                } else {
                    ttVar.cfv.result = -1;
                }
            } else {
                ttVar.cfv.result = -1;
            }
            a.sFg.m(ttVar);
        }
    }
}
