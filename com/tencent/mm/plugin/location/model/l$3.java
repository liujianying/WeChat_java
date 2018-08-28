package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.a.oa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class l$3 extends c<oa> {
    final /* synthetic */ l kDB;

    l$3(l lVar) {
        this.kDB = lVar;
        this.sFo = oa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oa oaVar = (oa) bVar;
        x.d("MicroMsg.SubCoreLocation", "trackEvent state " + oaVar.bYW.ahg);
        if (oaVar.bYW.ahg) {
            if (l.aZi().aZn() && l.aZi().kDO) {
                l.aZi().aZo();
            }
        } else if (l.aZi().aZn()) {
            o aZi = l.aZi();
            x.d("MicorMsg.TrackRefreshManager", "pause refresh");
            aZi.kDO = true;
            if (aZi.dMm != null) {
                aZi.dMm.c(aZi.cXs);
            }
            if (aZi.kDF != null) {
                aZi.kDF.b(aZi.kDU);
            }
        }
        return false;
    }
}
