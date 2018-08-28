package com.tencent.mm.ak;

import com.tencent.mm.kernel.g;

class i$6 implements Runnable {
    final /* synthetic */ i dVa;
    final /* synthetic */ e dVd;
    final /* synthetic */ int dVe;

    i$6(i iVar, e eVar, int i) {
        this.dVa = iVar;
        this.dVd = eVar;
        this.dVe = i;
    }

    public final void run() {
        g.Eh().dpP.a(new l((int) this.dVd.dTK, this.dVe, (byte) 0), 0);
    }
}
