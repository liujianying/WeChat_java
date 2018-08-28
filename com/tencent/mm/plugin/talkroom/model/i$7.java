package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$7 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ i oxm;

    i$7(i iVar, int i) {
        this.oxm = iVar;
        this.bFr = i;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d iA : this.oxm.cWy) {
                iA.iA(this.bFr);
            }
        }
    }
}
