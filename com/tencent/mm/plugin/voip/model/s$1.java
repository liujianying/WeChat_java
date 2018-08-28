package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al.a;

class s$1 implements a {
    final /* synthetic */ s oNG;

    s$1(s sVar) {
        this.oNG = sVar;
    }

    public final boolean vD() {
        if (this.oNG.oHa.oJX.oOk == 1) {
            j jVar = this.oNG.oHa;
            boolean z = jVar.mStatus == 2 || jVar.mStatus == 4;
            if (z) {
                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipServiceEx", "call timeout!");
                this.oNG.oHa.oJX.oPS.oKQ = 101;
                h.mEJ.h(11521, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis())});
                this.oNG.bLg();
                this.oNG.oHa.oJY.bKy();
            }
        }
        return false;
    }
}
