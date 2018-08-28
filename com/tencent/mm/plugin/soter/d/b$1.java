package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.soter.c.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.b;

class b$1 implements b<Boolean> {
    final /* synthetic */ long cXh;
    final /* synthetic */ e onJ;

    b$1(long j, e eVar) {
        this.cXh = j;
        this.onJ = eVar;
    }

    public final /* synthetic */ void aF(Object obj) {
        x.i("MicroMsg.SoterInitManager", "alvinluo onTerminate");
        x.i("MicroMsg.SoterInitManager", "alvinluo init takes %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.cXh)});
        if (this.onJ != null) {
            this.onJ.xR(0);
        }
    }
}
