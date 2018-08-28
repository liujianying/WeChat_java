package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.g.a.hm;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<hm> {
    public b() {
        this.sFo = hm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        hm hmVar = (hm) bVar;
        if (hmVar instanceof hm) {
            x.i("MicroMsg.GetSoterSupportEventListener", "hy: request is support soter");
            x.i("MicroMsg.GetSoterSupportEventListener", "alvinluo isSupportSoter: %b", new Object[]{Boolean.valueOf(h.bFl())});
            if (h.bFl()) {
                hmVar.bQR.bQS = 1;
            } else {
                hmVar.bQR.bQS = 0;
            }
        }
        return true;
    }
}
