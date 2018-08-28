package com.tencent.mm.ak;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements Runnable {
    final /* synthetic */ i dVa;
    final /* synthetic */ l dVc;

    i$2(i iVar, l lVar) {
        this.dVa = iVar;
        this.dVc = lVar;
    }

    public final void run() {
        x.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[]{Boolean.valueOf(i.b(this.dVa)), Integer.valueOf(this.dVc.hashCode())});
        if (i.b(this.dVa)) {
            i.a(this.dVa).offer(this.dVc);
            return;
        }
        g.Eh().dpP.a(this.dVc, 0);
        i.a(this.dVa, true);
    }
}
