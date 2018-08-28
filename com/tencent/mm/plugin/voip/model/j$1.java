package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements a {
    final /* synthetic */ j oKq;

    j$1(j jVar) {
        this.oKq = jVar;
    }

    public final boolean vD() {
        x.v("MicroMsg.Voip.VoipContext", "voip repeat sync");
        this.oKq.oKa.a(null, false, 7);
        return true;
    }
}
