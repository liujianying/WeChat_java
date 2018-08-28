package com.tencent.mm.modelstat;

import com.tencent.mm.storage.bd;

class b$3 implements Runnable {
    final /* synthetic */ bd dAB;
    final /* synthetic */ b ehO;

    b$3(b bVar, bd bdVar) {
        this.ehO = bVar;
        this.dAB = bdVar;
    }

    public final void run() {
        b.a(this.ehO, this.dAB, 0);
    }
}
