package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.b.b;

class b$2 implements Runnable {
    final /* synthetic */ b nmK;
    final /* synthetic */ b nmL;

    b$2(b bVar, b bVar2) {
        this.nmL = bVar;
        this.nmK = bVar2;
    }

    public final void run() {
        b bVar = this.nmL;
        bVar.dba.remove(this.nmK);
        int i = b.nmz - 1;
        b.nmz = i;
        if (i <= 0) {
            g.Ek();
            g.Eh().dpP.b(208, bVar);
        }
    }
}
