package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$4 implements Runnable {
    final /* synthetic */ i oxm;

    i$4(i iVar) {
        this.oxm = iVar;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d Sy : this.oxm.cWy) {
                Sy.Sy();
            }
        }
    }
}
