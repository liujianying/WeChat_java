package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip_cs.b.c.b;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements a {
    final /* synthetic */ d oXy;

    d$2(d dVar) {
        this.oXy = dVar;
    }

    public final boolean vD() {
        x.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
        au.DF().a(795, this.oXy);
        au.DF().a(new b(b.bMv().kqx.oOl, b.bMv().kqx.kpp), 0);
        return true;
    }
}
