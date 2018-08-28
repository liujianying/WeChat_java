package com.tencent.mm.modelvoice;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;

class r$1 implements Runnable {
    final /* synthetic */ c eoG;
    final /* synthetic */ p epQ;
    final /* synthetic */ r epR;

    r$1(r rVar, c cVar, p pVar) {
        this.epR = rVar;
        this.eoG = cVar;
        this.epQ = pVar;
    }

    public final void run() {
        this.eoG.D(((i) g.l(i.class)).bcY().I(this.epQ.bWJ, this.epQ.bYu));
    }
}
