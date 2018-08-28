package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$6 implements Runnable {
    final /* synthetic */ i oxm;

    i$6(i iVar) {
        this.oxm = iVar;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d Su : this.oxm.cWy) {
                Su.Su();
            }
        }
    }
}
