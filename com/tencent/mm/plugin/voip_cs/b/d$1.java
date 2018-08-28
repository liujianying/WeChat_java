package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ d oXy;

    d$1(d dVar) {
        this.oXy = dVar;
    }

    public final boolean vD() {
        x.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
        this.oXy.bMB();
        return true;
    }
}
