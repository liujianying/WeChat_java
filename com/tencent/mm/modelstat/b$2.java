package com.tencent.mm.modelstat;

import com.tencent.mm.storage.bd;

class b$2 implements Runnable {
    final /* synthetic */ bd dAB;
    final /* synthetic */ b ehO;
    final /* synthetic */ int ehP;

    b$2(b bVar, bd bdVar, int i) {
        this.ehO = bVar;
        this.dAB = bdVar;
        this.ehP = i;
    }

    public final void run() {
        b.a(this.ehO, this.dAB, this.ehP);
    }
}
