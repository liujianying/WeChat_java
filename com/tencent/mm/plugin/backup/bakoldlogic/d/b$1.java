package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ long cXh;
    final /* synthetic */ b$a hbc;
    final /* synthetic */ int hbd = -1;
    final /* synthetic */ b hbe;

    b$1(b bVar, long j, b$a b_a) {
        this.hbe = bVar;
        this.cXh = j;
        this.hbc = b_a;
    }

    public final void run() {
        g.Eg().Ds();
        x.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[]{Integer.valueOf(b.bB()), Long.valueOf(bi.bH(this.cXh))});
        b.wy();
        au.Em().a(new 1(this));
    }
}
