package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.al.a;

class j$6 implements a {
    final /* synthetic */ j oKq;

    j$6(j jVar) {
        this.oKq = jVar;
    }

    public final boolean vD() {
        if (j.c(this.oKq) == 4) {
            com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
            this.oKq.oJX.oPS.oKQ = 105;
            this.oKq.o(1, -9000, "");
        }
        return false;
    }
}
