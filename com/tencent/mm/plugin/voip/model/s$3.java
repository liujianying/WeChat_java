package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.model.a.f;
import com.tencent.mm.sdk.platformtools.al.a;

class s$3 implements a {
    final /* synthetic */ s oNG;

    s$3(s sVar) {
        this.oNG = sVar;
    }

    public final boolean vD() {
        if (this.oNG.oHa.oJX.kpo == 0) {
            com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", g.Ac() + " roomId == 0 ");
            s.c(this.oNG).SO();
        } else {
            if (this.oNG.oHa.mStatus >= 5) {
                new f(this.oNG.oHa.oJX.kpo, this.oNG.oHa.oJX.kpp, this.oNG.oHa.oKj).bLp();
            }
        }
        return true;
    }
}
