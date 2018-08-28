package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$9 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ i oxm;
    final /* synthetic */ String oxq;

    i$9(i iVar, int i, int i2, String str) {
        this.oxm = iVar;
        this.bFq = i;
        this.bFr = i2;
        this.oxq = str;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d b : this.oxm.cWy) {
                b.b(this.bFq, this.bFr, this.oxq);
            }
        }
    }
}
