package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.ag;

class b$1 implements Runnable {
    final /* synthetic */ ag hlG;
    final /* synthetic */ b sFq;
    final /* synthetic */ c sFr;
    final /* synthetic */ b sFs;

    b$1(b bVar, b bVar2, c cVar, ag agVar) {
        this.sFs = bVar;
        this.sFq = bVar2;
        this.sFr = cVar;
        this.hlG = agVar;
    }

    public final void run() {
        this.sFs.a(this.sFq, this.sFr);
        if (this.hlG != null) {
            this.hlG.post(new 1(this));
        } else {
            this.sFr.onComplete();
        }
    }
}
