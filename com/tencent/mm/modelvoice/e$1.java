package com.tencent.mm.modelvoice;

import com.tencent.mm.storage.bd;

class e$1 implements Runnable {
    final /* synthetic */ bd dAs;
    final /* synthetic */ c eoG;
    final /* synthetic */ e eoH;

    e$1(e eVar, c cVar, bd bdVar) {
        this.eoH = eVar;
        this.eoG = cVar;
        this.dAs = bdVar;
    }

    public final void run() {
        this.eoG.D(this.dAs);
    }
}
