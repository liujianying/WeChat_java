package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.g.a.hk;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<hk> {
    public a() {
        this.sFo = hk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 1;
        hk hkVar = (hk) bVar;
        x.i("MicroMsg.GetIsEnrolledListener", "hy: check mode: %d", new Object[]{Integer.valueOf(hkVar.bQI.bQK)});
        if (hkVar.bQI.bQK == 1 && h.bFl()) {
            x.i("MicroMsg.GetIsEnrolledListener", "hy: has enrolled fingerprint: %b", new Object[]{Boolean.valueOf(com.tencent.d.a.a.hz(ad.getContext()))});
            hk.b bVar2 = hkVar.bQJ;
            if (!com.tencent.d.a.a.hz(ad.getContext())) {
                i = 0;
            }
            bVar2.bQL = i;
        } else {
            x.w("MicroMsg.GetIsEnrolledListener", "hy: not support");
            hkVar.bQJ.bQL = -1;
        }
        return false;
    }
}
